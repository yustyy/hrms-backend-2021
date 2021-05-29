package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	JobService jobService;
	
	@Autowired
	public JobPositionsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return jobService.getAll();
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<JobPosition> get(@RequestParam int id) {
		return jobService.get(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition job) {
		return jobService.add(job);
	}
	

}
