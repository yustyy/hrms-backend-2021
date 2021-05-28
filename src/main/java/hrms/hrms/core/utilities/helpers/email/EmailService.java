package hrms.hrms.core.utilities.helpers.email;

import hrms.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
