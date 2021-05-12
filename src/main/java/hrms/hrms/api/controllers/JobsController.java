package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	
	@GetMapping("/getall")
	public List<Job> getAll(){
		return jobService.getAll();
	}
	
	
	@GetMapping("/getbyid")
		public Job get(int id) {
			return jobService.get(id);
		}
	

}
