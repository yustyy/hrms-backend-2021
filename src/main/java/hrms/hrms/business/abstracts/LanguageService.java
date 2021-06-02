package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
	
	DataResult<Language> getById(int id);
	
	DataResult<List<Language>> getAll();
}
