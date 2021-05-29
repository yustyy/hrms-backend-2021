package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

	JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return jobAdvertService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return jobAdvertService.getById(id);
	}
	
	@GetMapping("/getallbyisopen")
	public DataResult<List<JobAdvert>> getAllByIsOpen(@RequestParam boolean isOpen){
		return jobAdvertService.getAllByIsOpen(isOpen);
	}
	
	@GetMapping("/getAllByIsOpenOrderByPublishedAtDesc")
	public DataResult<List<JobAdvert>> getAllByIsOpenOrderByPublishedAtDesc(@RequestParam boolean isOpen){
		return jobAdvertService.getAllByIsOpenOrderByPublishedAtDesc(isOpen);
	}
	
	@GetMapping("/getAllByEmployer")
	public DataResult<List<JobAdvert>> getAllByEmployerId(@RequestParam int employerId){
		return jobAdvertService.getAllByEmployerId(employerId);
	}
}
