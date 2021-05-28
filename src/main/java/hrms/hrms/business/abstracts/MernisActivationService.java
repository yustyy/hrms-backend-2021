package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.MernisActivation;

public interface MernisActivationService {
	Result add(MernisActivation mernisActivation);
	
	DataResult<List<MernisActivation>> getAll();
	DataResult<MernisActivation> get(int id);
	DataResult<MernisActivation> getByUserId(int userId);
}
