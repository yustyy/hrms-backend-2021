package hrms.hrms.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.ImageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;

	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/addwithlink")
	public Result add(@Valid @RequestBody Image image) {
		return imageService.add(image);
	}
	
	@PostMapping("/addwithimage") 
	public Result addWithImage(@RequestParam int userId, @RequestParam("file") MultipartFile file) {
		return imageService.addAndSave(userId, file);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return imageService.getAll();
	}

}
