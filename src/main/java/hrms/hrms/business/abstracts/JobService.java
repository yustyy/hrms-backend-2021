package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;

public interface JobService {
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> get(int id);
	
	
}
