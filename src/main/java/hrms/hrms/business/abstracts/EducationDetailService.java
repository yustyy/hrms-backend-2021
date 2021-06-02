package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationDetail;

public interface EducationDetailService {
	
Result add(EducationDetail school);
	
	DataResult<EducationDetail> getById(int id);
	
	DataResult<List<EducationDetail>> getAll();
}
