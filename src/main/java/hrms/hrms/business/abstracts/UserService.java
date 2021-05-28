package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.User;

public interface UserService {
	
	Result add(User user);
	
	DataResult<List<User>> getAll();
	DataResult<User> get(int id);
	
	Result existsByEmail(String email);
}
