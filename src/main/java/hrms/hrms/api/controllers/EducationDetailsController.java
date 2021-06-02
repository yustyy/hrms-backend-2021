package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EducationDetailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EducationDetail;

@RestController
@RequestMapping("/api/educationdetails")
public class EducationDetailsController {
	
	private EducationDetailService educationDetailService;

	@Autowired
	public EducationDetailsController(EducationDetailService educationDetailService) {
		this.educationDetailService = educationDetailService;
	};
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EducationDetail educationDetail) {
		return educationDetailService.add(educationDetail);
	}
	
	@GetMapping("/getbyid")
	public DataResult<EducationDetail> getById(@RequestParam int id){
		return educationDetailService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<EducationDetail>> getAll(){
		return educationDetailService.getAll();
	}


}
