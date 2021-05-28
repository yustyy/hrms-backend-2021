package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmailActivationService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.helpers.email.EmailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmailActivationDao;
import hrms.hrms.entities.concretes.EmailActivation;

@Service
public class EmailActivationManager implements EmailActivationService {

	EmailActivationDao emailActivationDao;
	EmailService emailService;
	UserService userService;
	
	public EmailActivationManager(EmailActivationDao emailActivationDao, EmailService emailService,
			UserService userService) {
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
		this.userService = userService;
	}
	
	@Override
	public Result add(EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		return new SuccessDataResult<List<EmailActivation>>(emailActivationDao.findAll(), "Tüm datalar getirildi!");
	}

	@Override
	public DataResult<EmailActivation> getById(int id) {
		return new SuccessDataResult<EmailActivation>(emailActivationDao.findById(id).get(), id+" idli data getirildi!");
	}

	@Override
	public Result createAndSendByMail(int userId, String mail) {
		
		// Taken from ahmet-cetinkaya hrms github project, will refactor with my own codes.
		
		
		EmailActivation emailActivation = new EmailActivation(0, "123456789", false, userService.get(userId).getData());
		
		// TODO ----------
		
		emailService.send(
				mail,
				"Hesabınızı doğrulayın!", 
				"Lütfen hesabınızı doğrulayın!" + "www.localhost:8080/api/emailactivations/verify?authToken=" +
				emailActivation.getAuthToken()+ "&email="+mail);
		
		return new SuccessResult("Doğrulama linki, eposta hesabınızı gönderildi!");
	}

	@Override
	public Result verify(String email, String authToken) {
		
		DataResult<EmailActivation> result = getByEmailAndAuthToken(email, authToken);
		
		if(!result.isSuccess()) {
			return new ErrorResult("Mail doğrulanamadı!");
		}
		
		result.getData().setApproved(true);
		emailActivationDao.save(result.getData());
		
		return new SuccessResult("Email doğrulandı!");
		
	}

	@Override
	public DataResult<EmailActivation> getByEmailAndAuthToken(String email, String authToken) {
		return new SuccessDataResult<EmailActivation>(emailActivationDao.getByUser_EmailAndAuthToken(email, authToken), "Başarılı!");
	}

}
