package hrms.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(String to, String title, String body) {
		//TODO -----
		return new SuccessResult("Email gönderildi!");
	}

}
