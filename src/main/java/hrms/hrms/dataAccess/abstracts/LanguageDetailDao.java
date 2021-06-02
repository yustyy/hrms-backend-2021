package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.LanguageDetail;

public interface LanguageDetailDao extends JpaRepository<LanguageDetail, Integer> {

}
