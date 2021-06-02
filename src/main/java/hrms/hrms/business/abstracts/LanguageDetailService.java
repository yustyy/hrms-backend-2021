package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LanguageDetail;

public interface LanguageDetailService {
	Result add(LanguageDetail languageDetail);
	
	DataResult<LanguageDetail> getById(int id);
	
	DataResult<List<LanguageDetail>> getAll();
}
