package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.EducationDetail;

public interface EducationDetailsDao extends JpaRepository<EducationDetail, Integer> {

}
