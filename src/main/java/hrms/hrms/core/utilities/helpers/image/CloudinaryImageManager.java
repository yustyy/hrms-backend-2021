package hrms.hrms.core.utilities.helpers.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;



@Service
public class CloudinaryImageManager implements ImageUploadService {
	
	private Cloudinary cloudinary;
	
	private Environment environment;
	
	@Autowired
	public CloudinaryImageManager(Environment environment) {
		super();
		this.environment = environment;
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", environment.getProperty("cloudinary.cloud.name"),
				"api_key", environment.getProperty("cloudinary.api.key"),
				"api_secret", environment.getProperty("cloudinary.api.secret")));
		
	}


	@Override
	public DataResult<?> save(MultipartFile image) {
	
		Map result;
		
		try {
			result = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
			
		} catch (IOException e) {
			return new ErrorDataResult<Map>(e.getMessage());
		}
		
		return new SuccessDataResult<Map>(result);
		
	}

}
