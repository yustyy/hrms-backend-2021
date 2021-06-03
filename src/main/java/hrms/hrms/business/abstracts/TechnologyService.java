package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Technology;

public interface TechnologyService {

	Result add(Technology technology);
	
	DataResult<Technology> getById(int id);
	
	DataResult<List<Technology>> getAll();
	
}
