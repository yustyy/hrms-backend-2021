package hrms.hrms.core.adapters.validation.concretes;

import hrms.hrms.core.adapters.validation.abstracts.UserVerificationService;
import hrms.hrms.entities.concretes.JobSeeker;

public class UserVerificationTest implements UserVerificationService {

	@Override
	public boolean validateJobSeeker(JobSeeker jobSeeker) {
		return true;
	}

}
