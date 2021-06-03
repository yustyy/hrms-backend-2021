package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {

}
