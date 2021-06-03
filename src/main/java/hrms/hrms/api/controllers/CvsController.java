package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CvService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	
	private CvService cvService;

	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return cvService.add(cv);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Cv> getById(@RequestParam int id){
		return cvService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll(){
		return cvService.getAll();
	}

}
