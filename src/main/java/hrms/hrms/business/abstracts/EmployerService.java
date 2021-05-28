package hrms.hrms.business.abstracts;

import hrms.hrms.entities.concretes.Employer;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;

public interface EmployerService {

	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
}
