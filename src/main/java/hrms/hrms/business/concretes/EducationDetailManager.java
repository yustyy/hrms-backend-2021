package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EducationDetailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EducationDetailsDao;
import hrms.hrms.entities.concretes.EducationDetail;

@Service
public class EducationDetailManager implements EducationDetailService {

	private EducationDetailsDao educationDetailDao;
	
	@Autowired
	public EducationDetailManager(EducationDetailsDao educationDetailDao) {
		super();
		this.educationDetailDao = educationDetailDao;
	}

	@Override
	public Result add(EducationDetail educationDetail) {
		educationDetailDao.save(educationDetail);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<EducationDetail> getById(int id) {
		return new SuccessDataResult<EducationDetail>(educationDetailDao.findById(id).get(), id+" idli okul detayı getirildi!");
	}

	@Override
	public DataResult<List<EducationDetail>> getAll() {
		return new SuccessDataResult<List<EducationDetail>>(educationDetailDao.findAll(), "Tüm data getirildi!");
	}

}
