package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.TechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.TechnologyDao;
import hrms.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public Result add(Technology technology) {
		technologyDao.save(technology);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<Technology> getById(int id) {
		return new SuccessDataResult<Technology>(technologyDao.findById(id).get(), id+" idli teknoloji getirildi!");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(technologyDao.findAll(), "Tüm data getirildi!");
	}

}
