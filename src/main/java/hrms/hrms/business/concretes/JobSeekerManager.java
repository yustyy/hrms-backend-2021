package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.business.abstracts.MernisActivationService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.adapters.validation.abstracts.UserVerificationService;
import hrms.hrms.core.utilities.business.BusinessRules;
import hrms.hrms.core.utilities.helpers.email.EmailManager;
import hrms.hrms.core.utilities.helpers.email.EmailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.concretes.MernisActivation;
import hrms.hrms.entities.concretes.User;


@Service
public class JobSeekerManager implements JobSeekerService {
	
	JobSeekerDao jobSeekerDao;
	UserVerificationService userVerificationService;
	UserService userService;
	MernisActivationService mernisActivationService;
	EmailService emailService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserVerificationService userVerificationService, 
			UserService userService, MernisActivationService mernisActivationService,
			EmailService emailManager) {
		this.jobSeekerDao = jobSeekerDao;
		this.userVerificationService = userVerificationService;
		this.userService = userService;	
		this.mernisActivationService = mernisActivationService;
		this.emailService = emailService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		Result[] checkList = {
				checkIfEmailExists(jobSeeker.getEmail()),
				checkIfRealPerson(jobSeeker),
				checkIfNationalityIdExists(jobSeeker.getNationalIdentity())};
		
		Result result = BusinessRules.run(checkList);
		
		
		if(result.isSuccess()) {
			jobSeekerDao.save(jobSeeker);				
			
			MernisActivation mernisActivation = new MernisActivation(0,true,jobSeeker);
			mernisActivationService.add(mernisActivation);
			
			
			return new SuccessResult("Başarılı!");
		}else {
			return result;
		}

	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "Tüm iş arayanlar getirildi!");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findById(id).get(), id+" idli iş arayan getirildi!");
	}
	
	@Override
	public Result existsByNationalityId(String nationalityId) {
		if(jobSeekerDao.existsByNationalIdentity(nationalityId)) {
			return new SuccessResult("Bu tcno zaten kullanımda!");
		}
		return new ErrorResult();
	}
	
	
	private Result checkIfEmailExists(String email) {
		if(userService.existsByEmail(email).isSuccess()) {
			return new ErrorResult("Bu email zaten kullanımda!");
		}
		return new SuccessResult();
	}
	
	private Result checkIfNationalityIdExists(String nationalIdentity) {
		if(existsByNationalityId(nationalIdentity).isSuccess()) {
			return new ErrorResult("Bu tcno zaten kullanımda!");
		}
		return new SuccessResult();
	}
	
	
	private Result checkIfRealPerson(JobSeeker jobSeeker) {
		if(!userVerificationService.validateJobSeeker(jobSeeker)) {
			return new ErrorResult("Geçersiz kimlik bilgileri!");
		}
		return new SuccessResult();
	}
	
	

}
