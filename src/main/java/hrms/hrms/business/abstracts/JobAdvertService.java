package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> getById(int id);
	
	DataResult<List<JobAdvert>> getAllByIsOpen(boolean isOpen);
	DataResult<List<JobAdvert>> getAllByIsOpenOrderByPublishedAtDesc(boolean isOpen);
	DataResult<List<JobAdvert>> getAllByEmployerId(int employerId);
}
