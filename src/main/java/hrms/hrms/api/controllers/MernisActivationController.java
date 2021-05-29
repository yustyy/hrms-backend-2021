package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.MernisActivationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.MernisActivation;

@RestController
@RequestMapping("/api/mernisactivations")
public class MernisActivationController {
	
	MernisActivationService mernisActivationService;

	@Autowired
	public MernisActivationController(MernisActivationService mernisActivationService) {
		this.mernisActivationService = mernisActivationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MernisActivation mernisActivation) {
		return mernisActivationService.add(mernisActivation);
	}
	
	@GetMapping("/getall")
	public DataResult<List<MernisActivation>> getAll(){
		return mernisActivationService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<MernisActivation> getById(@RequestParam int id){
		return mernisActivationService.get(id);
	}
	
	@GetMapping("/getbyuserid")
	public DataResult<MernisActivation> getByUserId(@RequestParam int userId){
		return mernisActivationService.getByUserId(userId);
	}
	
	
	
}
