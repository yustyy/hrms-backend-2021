package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CompanyStaffService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CompanyStaffDao;
import hrms.hrms.entities.concretes.CompanyStaff;

@Service
public class CompanyStaffManager implements CompanyStaffService {

	CompanyStaffDao companyStaffDao;
	
	@Autowired
	public CompanyStaffManager(CompanyStaffDao companyStaffDao) {
		this.companyStaffDao = companyStaffDao;
	}
	
	@Override
	public Result add(CompanyStaff companyStaff) {
		companyStaffDao.save(companyStaff);
		
		return new SuccessResult("Başarılı!");
	}

	@Override
	public DataResult<List<CompanyStaff>> getAll() {
		return new SuccessDataResult<List<CompanyStaff>>(companyStaffDao.findAll(), "Tüm data getirildi!");
	}

	@Override
	public DataResult<CompanyStaff> getById(int id) {
		return new SuccessDataResult<CompanyStaff>(companyStaffDao.findById(id).get(), id+" idli data getirildi!");
	}

}
