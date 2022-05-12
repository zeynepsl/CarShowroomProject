package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.car.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

public interface CarService extends BaseService<Car>, 
                                    AddService<CreateCarRequestDto>, 
                                    GetService<CarResponseDto>, GetAllService<List<CarResponseDto>>{
	
	DataResult<CarResponseDto> setSaleCount(int carId);
	
	List<CarResponseDto> toCarResponseDtoList(List<Car> cars);
	
	DataResult<List<CarResponseDto>> findByNameStartingWith(String prefix);
	DataResult<List<CarResponseDto>> findByNameEndingWith(String suffix);
	DataResult<List<CarResponseDto>> findByNameContaining(String infix);
	DataResult<List<CarResponseDto>> findByNameLike(String likePattern);
	
	DataResult<List<CarResponseDto>> findByNameOrderByName(String name);// Z -A
	DataResult<List<CarResponseDto>> findByNameOrderByNameAsc(String name);// A - Z
	
	DataResult<List<CarResponseDto>> findByPriceLessThanEqual(Double price);
	DataResult<List<CarResponseDto>> findByPriceGreaterThanEqual(Double price);
	
	DataResult<List<CarResponseDto>> findByPriceBetween(Double startPrice, Double endPrice);
}
