package hrms.hrms.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {

	DataResult<?> save(MultipartFile image);
}
