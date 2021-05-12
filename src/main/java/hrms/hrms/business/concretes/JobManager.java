package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.dataAccess.abstracts.JobDao;
import hrms.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public void add(Job job) {
		jobDao.save(job);
		
	}

	@Override
	public void update(Job job) {
		//
		
	}

	@Override
	public void delete(Job job) {
		jobDao.delete(job);
		
	}

	@Override
	public List<Job> getAll() {
		return jobDao.findAll();
	}

	@Override
	public Job get(int id) {
		return jobDao.findById(id).get();
	}

}
