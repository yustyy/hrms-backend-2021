package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

}
