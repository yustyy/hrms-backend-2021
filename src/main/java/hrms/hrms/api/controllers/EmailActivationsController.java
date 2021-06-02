package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmailActivationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.EmailActivation;

@RestController
@RequestMapping("/api/emailactivations")
public class EmailActivationsController {

	EmailActivationService emailActivationService;
	
	@Autowired
	public EmailActivationsController(EmailActivationService emailActivationService) {
		this.emailActivationService = emailActivationService;
	}
	
	@GetMapping("/verify")
	public Result verify(@RequestParam String email,@RequestParam String authToken) {
		return emailActivationService.verify(email, authToken);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmailActivation emailActivation) {
		return emailActivationService.add(emailActivation);
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmailActivation>> getAll(){
		return emailActivationService.getAll();
	}
	
}
