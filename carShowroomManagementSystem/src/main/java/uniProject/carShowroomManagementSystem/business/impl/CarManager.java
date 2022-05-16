package uniProject.carShowroomManagementSystem.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CarService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.car.CarConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.CarDao;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.car.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService{

	private final CarDao carDao;
	private final CarConverter carConverter;
	
	
	//polymorphism: inheritance yoluyla
	@Override
	public Result add(CreateCarRequestDto createCarRequestDto) {
		Car car = carConverter.toCar(createCarRequestDto);
		carDao.save(car);
		return new SuccessResult(Messages.added);
	}


	@Override
	public Result delete(int id) {
		Car car = getById(id).getData();
		if(car == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		carDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Car entity) {
		carDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<Car> getById(int id) {
		Car car = carDao.findById(id).orElse(null);
		if(car == null) {
			return new ErrorDataResult<Car>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Car>(car, Messages.viewed);
	}
	
	@Override
	public DataResult<CarResponseDto> get(int id) {
		Car car = getById(id).getData();
		if(car == null) {
			return new ErrorDataResult<CarResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<CarResponseDto>(carConverter.toCarResponseDto(car), Messages.viewed);
	}
	
	//araba satildiginda satis sayisini 1 arttir
	@Override
	public DataResult<CarResponseDto> setSaleCount(int carId) {
		Car car = carDao.findById(carId).orElse(null);
		if(car == null) {
			return new ErrorDataResult<CarResponseDto>(null, Messages.isNotExist);
		}
		car.setSaleCount(car.getSaleCount() + 1);
		carDao.save(car);
		
		return new SuccessDataResult<CarResponseDto>(carConverter.toCarResponseDto(car), Messages.viewed);
	}
	
	@Override
	public List<CarResponseDto> toCarResponseDtoList(List<Car> cars){
		List<CarResponseDto> carResponseDtos = new ArrayList<CarResponseDto>();
		cars.forEach(car -> {
			CarResponseDto carResponseDto = carConverter.toCarResponseDto(car);
			carResponseDtos.add(carResponseDto);
		});
		return carResponseDtos;
	}
	
	@Override
	public DataResult<List<CarResponseDto>> getAll() {
		return new SuccessDataResult<List<CarResponseDto>>(toCarResponseDtoList(carDao.findAll()), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameStartingWith(String prefix) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameStartingWith(prefix)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameEndingWith(String suffix) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameEndingWith(suffix)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameContaining(String infix) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameContaining(infix)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameLike(String likePattern) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameLike(likePattern)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameOrderByName(String name){
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameOrderByName(name)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByNameOrderByNameAsc(String name) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByNameOrderByNameAsc(name)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByPriceLessThanEqual(Double price) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByPriceLessThanEqual(price)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByPriceGreaterThanEqual(Double price) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByPriceGreaterThanEqual(price)), Messages.listed);
	}

	@Override
	public DataResult<List<CarResponseDto>> findByPriceBetween(Double startPrice, Double endPrice) {
		return new SuccessDataResult<List<CarResponseDto>>(
				toCarResponseDtoList(carDao.findByPriceBetween(startPrice, endPrice)), Messages.listed);
	}


}
