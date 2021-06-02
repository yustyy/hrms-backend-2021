package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SchoolDao;
import hrms.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}
	

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		
		return new SuccessResult("Başarılı!");
		
	}

	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(schoolDao.findById(id).get(), id+" idli okul getirildi!");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(schoolDao.findAll(), "Tüm data getirildi!");
	}

}
