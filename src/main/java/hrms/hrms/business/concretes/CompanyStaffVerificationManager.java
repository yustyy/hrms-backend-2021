package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CompanyStaffService;
import hrms.hrms.business.abstracts.CompanyStaffVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CompanyStaffVerificationDao;
import hrms.hrms.entities.concretes.CompanyStaff;
import hrms.hrms.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager implements CompanyStaffVerificationService {

	CompanyStaffVerificationDao companyStaffVerificationDao;
	CompanyStaffService companyStaffService;
	
	@Autowired
	public CompanyStaffVerificationManager(CompanyStaffVerificationDao companyStaffVerificationDao,
			CompanyStaffService companyStaffService) {
		this.companyStaffVerificationDao = companyStaffVerificationDao;
		this.companyStaffService = companyStaffService;
		
	}
	
	@Override
	public Result add(CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<List<CompanyStaffVerification>> getAll() {
		return new SuccessDataResult<List<CompanyStaffVerification>>(companyStaffVerificationDao.findAll(), "Tüm data getirildi!");
	}

	@Override
	public DataResult<CompanyStaffVerification> get(int id) {
		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerificationDao.findById(id).get(), id+" idli data getirildi!");
	}

	@Override
	public Result verify(int verificationId, int companyStaffId) {
		CompanyStaffVerification companyStaffVerification = get(verificationId).getData();
		
		CompanyStaff companyStaff = companyStaffService.getById(companyStaffId).getData();
		
		companyStaffVerification.setCompanyStaff(companyStaff);
		companyStaffVerification.setApproved(true);
		add(companyStaffVerification);
		
		return new SuccessResult("Başarılı!");
	}

}
