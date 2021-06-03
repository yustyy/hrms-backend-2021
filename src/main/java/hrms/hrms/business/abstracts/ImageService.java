package hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image);
	
	DataResult<Image> getById(int id);
	
	DataResult<List<Image>> getAll();
	
	Result addAndSave(int userId, MultipartFile file);
	
	DataResult<Image> getByUserId(int userId);
	
}
