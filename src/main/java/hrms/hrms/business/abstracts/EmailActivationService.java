package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EmailActivation;

public interface EmailActivationService {
	Result add(EmailActivation emailActivation);
	
	DataResult<List<EmailActivation>> getAll();
	
	DataResult<EmailActivation> getById(int id);
	
	Result createAndSendByMail(int userId, String mail);
	
	Result verify(String email, String authToken);
	
	DataResult<EmailActivation> getByEmailAndAuthToken(String email, String authToken);
}
