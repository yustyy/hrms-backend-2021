package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		
		return new SuccessResult("başarılı!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findAll(), "Tüm data getirildi!");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(jobAdvertDao.findById(id).get(), id+" idli data getirildi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsOpen(boolean isOpen) {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByIsOpen(isOpen), "Tüm data getirildi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsOpenOrderByPublishedAtDesc(boolean isOpen) {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByIsOpenOrderByPublishedAtDesc(isOpen), "Tüm data getirildi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByEmployerId(employerId), "Tüm data getirildi!");
	}

}
