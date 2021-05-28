package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getById(int id);
	
	Result existsByNationalityId(String nationalityId);

}
