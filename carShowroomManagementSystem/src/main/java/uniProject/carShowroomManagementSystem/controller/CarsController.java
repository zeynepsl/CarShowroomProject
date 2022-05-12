package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.car.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarsController {
	private final CarService carService;
	
	@PostMapping("/cars")
	public Result add(@Valid @RequestBody CreateCarRequestDto entity) {
		return carService.add(entity);
	}
	
	@DeleteMapping("/cars/{carId}")
	public Result delete(@PathVariable int carId) {
		return carService.delete(carId);
	}

	@PutMapping("/cars")
	public Result update(@RequestBody Car entity) {
		return carService.update(entity);
	}

	@GetMapping("/cars/get/{carId}")
	public DataResult<CarResponseDto> getById(@PathVariable @Positive(message = "id must be positive") int carId) {
		return carService.get(carId);
	}
	
	@GetMapping("/cars")
	public DataResult<List<CarResponseDto>> getAll() {
		return carService.getAll();
	}
	
	@GetMapping("/cars/startingWith/{prefix}")
	public DataResult<List<CarResponseDto>> findByNameStartingWith(@RequestParam String prefix){
		return carService.findByNameStartingWith(prefix);
	}
	
	@GetMapping("/cars/endingWith/{suffix}")
	public DataResult<List<CarResponseDto>> findByNameEndingWith(@PathVariable String suffix){
		return carService.findByNameEndingWith(suffix);
	}
	
	@GetMapping("/cars/contains/{infix}")
	public DataResult<List<CarResponseDto>> findByNameContaining(@PathVariable String infix){
		return carService.findByNameContaining(infix);
	}
	
	@GetMapping("/cars/like/{pattern}")
	public DataResult<List<CarResponseDto>> findByNameLike(@PathVariable String pattern){
		return carService.findByNameLike(pattern);
	}
	
	@GetMapping("/cars/{name}")
	public DataResult<List<CarResponseDto>> findByNameOrderByName(@PathVariable String name){
		return carService.findByNameOrderByName(name);
	}
	
	@GetMapping("/cars/ascending/{name}")
	public DataResult<List<CarResponseDto>> findByNameOrderByNameAsc(@PathVariable String name){
		return carService.findByNameOrderByNameAsc(name);
	}
	
	@GetMapping("/cars/{price}/less")
	public DataResult<List<CarResponseDto>> findByPriceLessThanEqual(@PathVariable Double price){
		return carService.findByPriceLessThanEqual(price);
	}
	
	@GetMapping("/cars/{price}/greater")
	public DataResult<List<CarResponseDto>> findByPriceGreaterThanEqual(@PathVariable Double price){
		return carService.findByPriceGreaterThanEqual(price);
	}
	
	@GetMapping("/cars/{startPrice}/between/{endPrice}")
	public DataResult<List<CarResponseDto>> findByPriceBetween(@PathVariable Double startPrice, @PathVariable Double endPrice){
		return carService.findByPriceBetween(startPrice, endPrice);
	}
}
