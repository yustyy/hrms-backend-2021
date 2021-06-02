package hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.LanguageDetailService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LanguageDetail;

@RestController
@RequestMapping("/api/languagedetails")
public class LanguageDetailsController {

	private LanguageDetailService languageDetailService;

	@Autowired
	public LanguageDetailsController(LanguageDetailService languageDetailService) {
		super();
		this.languageDetailService = languageDetailService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LanguageDetail languageDetail) {
		return ResponseEntity.ok(languageDetailService.add(languageDetail));
	}
	
	@GetMapping("/getbyid")
	public DataResult<LanguageDetail> getById(@RequestParam int id){
		return languageDetailService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<LanguageDetail>> getAll(){
		return languageDetailService.getAll();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları!");
		return errors;
		
	}
	
	
	
}
