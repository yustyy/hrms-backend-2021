package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CvService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CvDao;
import hrms.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		cvDao.save(cv);
		
		return new SuccessResult("Başarılı");
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>(cvDao.findById(id).get(), id+" idli cv getirildi!");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(cvDao.findAll(), "Tüm data getirildi!");
	}

}
