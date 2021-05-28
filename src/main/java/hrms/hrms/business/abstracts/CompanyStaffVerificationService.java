package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService {
	Result add(CompanyStaffVerification companyStaff);
	
	DataResult<List<CompanyStaffVerification>> getAll();
	DataResult<CompanyStaffVerification> get(int id);
	
	Result verify(int userToVerify, int companyStaffId);
}
