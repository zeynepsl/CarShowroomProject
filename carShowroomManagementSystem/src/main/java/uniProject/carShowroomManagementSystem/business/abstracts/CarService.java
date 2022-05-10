package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

public interface CarService extends BaseService<Car>, AddService<CreateCarRequestDto>{
	DataResult<Car> setSaleCount(int carId);
	
	DataResult<List<Car>> findByNameStartingWith(String prefix);
	DataResult<List<Car>> findByNameEndingWith(String suffix);
	DataResult<List<Car>> findByNameContaining(String infix);
	DataResult<List<Car>> findByNameLike(String likePattern);
	
	DataResult<List<Car>> findByNameOrderByName(String name);// Z -A
	DataResult<List<Car>> findByNameOrderByNameAsc(String name);// A - Z
	
	DataResult<List<Car>> findByPriceLessThanEqual(Double price);
	DataResult<List<Car>> findByPriceGreaterThanEqual(Double price);
	
	DataResult<List<Car>> findByPriceBetween(Double startPrice, Double endPrice);
}
