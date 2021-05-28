package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobPositionDao;
import hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobService {

	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition job) {
		jobPositionDao.save(job);
		return new SuccessResult("İş başarıyla eklendi!");
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "Tüm işler getirildi!");
	}

	@Override
	public DataResult<JobPosition> get(int id) {
		return new SuccessDataResult<JobPosition>(jobPositionDao.findById(id).get(), id+" idli iş getirildi!");
	}

}
