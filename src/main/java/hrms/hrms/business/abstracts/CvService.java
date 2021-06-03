package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Cv;

public interface CvService {
	Result add(Cv cv);
	
	DataResult<Cv> getById(int id);
	
	DataResult<List<Cv>> getAll();
	
	DataResult<List<Cv>> getByUserId(int userId);
	
	

}
