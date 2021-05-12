package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

}
