package hrms.hrms.core.adapters.validation.abstracts;

import hrms.hrms.entities.concretes.JobSeeker;

public interface UserVerificationService {
	boolean validateJobSeeker(JobSeeker jobSeeker);
}
