package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CompanyStaffVerificationService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.CompanyStaffVerification;
import hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	EmployerDao employerDao;
	CompanyStaffVerificationService companyStaffVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, CompanyStaffVerificationService companyStaffVerificationService) {
		this.employerDao = employerDao;
		this.companyStaffVerificationService = companyStaffVerificationService;
		
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		
		companyStaffVerificationService.add(CompanyStaffVerification.builder().user(employer).build());
		
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Tüm iş verenler getirildi!"); 
	}

	@Override
	public DataResult<Employer> get(int id) {
		Optional<Employer> employer = employerDao.findById(id);
		
		if(employer.isEmpty()) {
			return new ErrorDataResult<Employer>(id+" idli bir iş veren bulunamadı!");
		}
		return new SuccessDataResult<Employer>(employer.get(), id+" idli iş veren getirildi!");
		
		
		
	}

}
