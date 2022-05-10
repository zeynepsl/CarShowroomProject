package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.car.CarConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.CarDao;
import uniProject.carShowroomManagementSystem.dto.CreateCarRequestDto;
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
	
	//ilgili araba kac adet satiliyor:
	@Override
	public DataResult<Car> setSaleCount(int carId) {
		Car car = carDao.findById(carId).orElse(null);
		if(car == null) {
			return new ErrorDataResult<Car>(null, Messages.isNotExist);
		}
		car.setSaleCount(car.getSaleCount() + 1);
		carDao.save(car);
		return new SuccessDataResult<Car>(car, Messages.viewed);
	}
	
	

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(carDao.findAll(), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameStartingWith(String prefix) {
		return new SuccessDataResult<List<Car>>(carDao.findByNameStartingWith(prefix), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameEndingWith(String suffix) {
		return new SuccessDataResult<List<Car>>(carDao.findByNameEndingWith(suffix), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameContaining(String infix) {
		return new SuccessDataResult<List<Car>>(carDao.findByNameContaining(infix), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameLike(String likePattern) {
		return new SuccessDataResult<List<Car>>(carDao.findByNameLike(likePattern), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameOrderByName(String name){
		return new SuccessDataResult<List<Car>>(carDao.findByNameOrderByName(name), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByNameOrderByNameAsc(String name) {
		return new SuccessDataResult<List<Car>>(carDao.findByNameOrderByNameAsc(name), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByPriceLessThanEqual(Double price) {
		return new SuccessDataResult<List<Car>>(carDao.findByPriceLessThanEqual(price), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByPriceGreaterThanEqual(Double price) {
		return new SuccessDataResult<List<Car>>(carDao.findByPriceGreaterThanEqual(price), Messages.listed);
	}

	@Override
	public DataResult<List<Car>> findByPriceBetween(Double startPrice, Double endPrice) {
		return new SuccessDataResult<List<Car>>(carDao.findByPriceBetween(startPrice, endPrice), Messages.listed);
	}


}
