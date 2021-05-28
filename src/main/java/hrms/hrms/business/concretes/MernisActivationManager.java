package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.MernisActivationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.MernisActivationDao;
import hrms.hrms.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager implements MernisActivationService {
	
	MernisActivationDao mernisActivationDao;
	
	@Autowired
	public MernisActivationManager(MernisActivationDao mernisActivationDao) {
		this.mernisActivationDao = mernisActivationDao;
	}

	@Override
	public Result add(MernisActivation mernisActivation) {
		mernisActivationDao.save(mernisActivation);
		return new SuccessResult("Başarıyla eklendi!");
	}

	@Override
	public DataResult<List<MernisActivation>> getAll() {
		return new SuccessDataResult<List<MernisActivation>>(mernisActivationDao.findAll(), "Tüm datalar getirildi!");
	}

	@Override
	public DataResult<MernisActivation> get(int id) {
		return new SuccessDataResult<MernisActivation>(mernisActivationDao.findById(id).get());
	}

	@Override
	public DataResult<MernisActivation> getByUserId(int userId) {
		return new SuccessDataResult<MernisActivation>(mernisActivationDao.getByUserId(userId));
	}

}
