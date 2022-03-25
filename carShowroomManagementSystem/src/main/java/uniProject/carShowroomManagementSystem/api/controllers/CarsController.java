package uniProject.carShowroomManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Car;

@RestController
@RequestMapping("/api/cars/")
public class CarsController {
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("findByNameStartingWith")
	public DataResult<List<Car>> findByNameStartingWith(@RequestParam String prefix){
		return carService.findByNameStartingWith(prefix);
	}
	
	@GetMapping("findByNameEndingWith")
	public DataResult<List<Car>> findByNameEndingWith(@RequestParam String suffix){
		return carService.findByNameEndingWith(suffix);
	}
	
	@GetMapping("findByNameContaining")
	public DataResult<List<Car>> findByNameContaining(@RequestParam String infix){
		return carService.findByNameContaining(infix);
	}
	
	@GetMapping("findByNameLike")
	public DataResult<List<Car>> findByNameLike(@RequestParam String likePattern){
		return carService.findByNameLike(likePattern);
	}
	
	@GetMapping("findByNameOrderByName")
	public DataResult<List<Car>> findByNameOrderByName(@RequestParam String name){
		return carService.findByNameOrderByName(name);
	}
	
	@GetMapping("findByNameOrderByNameAsc")
	public DataResult<List<Car>> findByNameOrderByNameAsc(@RequestParam String name){
		return carService.findByNameOrderByNameAsc(name);
	}
	
	@GetMapping("findByPriceLessThanEqual")
	public DataResult<List<Car>> findByPriceLessThanEqual(@RequestParam Double price){
		return carService.findByPriceLessThanEqual(price);
	}
	
	@GetMapping("findByPriceGreaterThanEqual")
	public DataResult<List<Car>> findByPriceGreaterThanEqual(@RequestParam Double price){
		return carService.findByPriceGreaterThanEqual(price);
	}
	
	@GetMapping("findByPriceBetween")
	public DataResult<List<Car>> findByPriceBetween(@RequestParam Double startPrice, @RequestParam Double endPrice){
		return carService.findByPriceBetween(startPrice, endPrice);
	}
}
