package uniProject.carShowroomManagementSystem.controller;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
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

import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

@RestController
@RequestMapping("/api")
@Validated
public class CarsController {
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping("/cars")
	public Result add(@RequestBody CreateCarRequestDto entity) {
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
	public DataResult<Car> getById(@PathVariable @Positive(message = "id must be positive") int carId) {
		return carService.getById(carId);
	}
	
	@GetMapping("/cars")
	public DataResult<List<Car>> getAll() {
		return carService.getAll();
	}
	
	@GetMapping("/cars/startingWith/{prefix}")
	public DataResult<List<Car>> findByNameStartingWith(@RequestParam String prefix){
		return carService.findByNameStartingWith(prefix);
	}
	
	@GetMapping("/cars/endingWith/{suffix}")
	public DataResult<List<Car>> findByNameEndingWith(@PathVariable String suffix){
		return carService.findByNameEndingWith(suffix);
	}
	
	@GetMapping("/cars/contains/{infix}")
	public DataResult<List<Car>> findByNameContaining(@PathVariable String infix){
		return carService.findByNameContaining(infix);
	}
	
	@GetMapping("/cars/like/{pattern}")
	public DataResult<List<Car>> findByNameLike(@PathVariable String pattern){
		return carService.findByNameLike(pattern);
	}
	
	@GetMapping("/cars/{name}")
	public DataResult<List<Car>> findByNameOrderByName(@PathVariable String name){
		return carService.findByNameOrderByName(name);
	}
	
	@GetMapping("/cars/ascending/{name}")
	public DataResult<List<Car>> findByNameOrderByNameAsc(@PathVariable String name){
		return carService.findByNameOrderByNameAsc(name);
	}
	
	@GetMapping("/cars/{price}/less")
	public DataResult<List<Car>> findByPriceLessThanEqual(@PathVariable Double price){
		return carService.findByPriceLessThanEqual(price);
	}
	
	@GetMapping("/cars/{price}/greater")
	public DataResult<List<Car>> findByPriceGreaterThanEqual(@PathVariable Double price){
		return carService.findByPriceGreaterThanEqual(price);
	}
	
	@GetMapping("/cars/{startPrice}/between/{endPrice}")
	public DataResult<List<Car>> findByPriceBetween(@PathVariable Double startPrice, @PathVariable Double endPrice){
		return carService.findByPriceBetween(startPrice, endPrice);
	}
}
