package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.LanguageDetailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LanguageDetailDao;
import hrms.hrms.entities.concretes.LanguageDetail;

@Service
public class LanguageDetailManager implements LanguageDetailService {

	private LanguageDetailDao languageDetailDao;
	
	@Autowired
	public LanguageDetailManager(LanguageDetailDao languageDetailDao) {
		super();
		this.languageDetailDao = languageDetailDao;
	}

	@Override
	public Result add(LanguageDetail languageDetail) {
		languageDetailDao.save(languageDetail);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<LanguageDetail> getById(int id) {
		return new SuccessDataResult<LanguageDetail>(languageDetailDao.findById(id).get(), id+" idli dil getirildi!");
	}

	@Override
	public DataResult<List<LanguageDetail>> getAll() {
		return new SuccessDataResult<List<LanguageDetail>>(languageDetailDao.findAll(), "Tüm data getirildi!");
	}

	
	
}
