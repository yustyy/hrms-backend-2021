package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	List<JobAdvert> getAllByIsOpen(boolean isOpen);
	
	List<JobAdvert> getAllByIsOpenOrderByPublishedAtDesc(boolean isOpen);
	
	List<JobAdvert> getAllByEmployerId(int employerId);
}
