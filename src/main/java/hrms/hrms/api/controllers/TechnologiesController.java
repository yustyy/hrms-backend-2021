package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.TechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Technology technology) {
		return technologyService.add(technology);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Technology>> getAll(){
		return technologyService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Technology> getById(@RequestParam int id){
		return technologyService.getById(id);
	}
	
}
