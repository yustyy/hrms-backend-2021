package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.ImageService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.helpers.image.ImageUploadService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ImageDao;
import hrms.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;
	
	private ImageUploadService imageUploadService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(Image image) {
		imageDao.save(image);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(imageDao.findById(id).get(), id+" idli fotoğraf getirildi!");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(imageDao.findAll(), "Tüm data getirildi!");
	}

	@Override
	public Result addAndSave(int userId, MultipartFile file) {
		
		Image image = getByUserId(userId).getData();
		
		Map<String, String> result = (Map<String, String>) imageUploadService.save(file).getData();
		image.setUrl(result.get("url"));
		
		return add(image);
		
		
	}

	@Override
	public DataResult<Image> getByUserId(int userId) {
		return new SuccessDataResult<Image>(imageDao.getByUserId(userId), "Image getirildi!");
	}

}
