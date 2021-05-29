package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CompanyStaffService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CompanyStaff;

@RestController
@RequestMapping("api/companystaffs")
public class CompanyStaffsController {

	CompanyStaffService companyStaffService;
	
	public CompanyStaffsController(CompanyStaffService companyStaffService) {
		this.companyStaffService = companyStaffService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CompanyStaff companyStaff) {
		return companyStaffService.add(companyStaff);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CompanyStaff>> getAll(){
		return companyStaffService.getAll();
	}
	
	@GetMapping("/get")
	public DataResult<CompanyStaff> getById(@RequestParam int id){
		return companyStaffService.getById(id);
	}
	
}
