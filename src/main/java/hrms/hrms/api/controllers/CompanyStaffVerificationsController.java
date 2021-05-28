package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CompanyStaffVerificationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CompanyStaffVerification;

@RestController
@RequestMapping("/api/companystaffverifications")
public class CompanyStaffVerificationsController {

	CompanyStaffVerificationService companyStaffVerificationService;
	
	@Autowired
	public CompanyStaffVerificationsController(CompanyStaffVerificationService companyStaffVerificationService) {
		this.companyStaffVerificationService = companyStaffVerificationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CompanyStaffVerification companyStaffVerification) {
		return companyStaffVerificationService.add(companyStaffVerification);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CompanyStaffVerification>> getAll(){
		return companyStaffVerificationService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CompanyStaffVerification> get(int id){
		return companyStaffVerificationService.get(id);
	}
	
	@GetMapping("/verify")
	public Result verify(int verificationId, int companyStaffId) {
		return companyStaffVerificationService.verify(verificationId, companyStaffId);
	}
	
}
