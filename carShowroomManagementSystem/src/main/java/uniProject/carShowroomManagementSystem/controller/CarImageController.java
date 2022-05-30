package uniProject.carShowroomManagementSystem.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CarImageService;
import uniProject.carShowroomManagementSystem.core.util.imageUpload.Response;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.dto.carimage.CarImageResponseDto;
import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.entity.CarImage;

@RestController
@RequestMapping("api/images")
@RequiredArgsConstructor
public class CarImageController {
	
	private final CarImageService carImageService;
	
	
	@RequestMapping(value = "/schedulebatch",method = RequestMethod.POST)
	public @ResponseBody DataResult<Response> add(@RequestPart("upfile") MultipartFile upfile, int carId){
		Car car = new Car();
		car.setId(carId);
		
		CarImage carImage = new CarImage();	
		carImage.setCar(car);
		
		carImageService.upload(carImage, upfile);
		return new SuccessDataResult<Response>();
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody CarImage carImage){
		carImageService.update(carImage);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarImageResponseDto> get(@PathVariable int id){
		return ResponseEntity.ok(carImageService.get(id).getData());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		carImageService.delete(id);
		return ResponseEntity.ok().build();
	}

}
