package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CompanyStaff;

public interface CompanyStaffService {
	Result add(CompanyStaff companyStaff);
	
	DataResult<List<CompanyStaff>> getAll();
	DataResult<CompanyStaff> getById(int id);
}
