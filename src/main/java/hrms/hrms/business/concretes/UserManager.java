package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.UserDao;
import hrms.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("Kullanıcı başarıyla eklendi!");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(), "Tüm kullanıcılar getirildi!");
	}

	@Override
	public DataResult<User> get(int id) {
		return new SuccessDataResult<User>(userDao.findById(id).get(), id+" idli kullanıcı getirildi!");
	}

	@Override
	public Result existsByEmail(String email) {
		if(userDao.existsByEmail(email)) {
			return new SuccessResult("Bu emaile sahip bir kullanıcı bulunuyor!");
		}
		return new ErrorResult("Bu emaile sahip bir kullanıcı bulunmuyor!");
		
		
	}

}
