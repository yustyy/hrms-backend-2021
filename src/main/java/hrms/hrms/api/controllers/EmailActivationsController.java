package hrms.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmailActivationService;
import hrms.hrms.core.utilities.results.Result;

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
	
}
