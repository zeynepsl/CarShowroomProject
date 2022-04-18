package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.CarDao;
import uniProject.carShowroomManagementSystem.entity.concrete.Brand;
import uniProject.carShowroomManagementSystem.entity.concrete.Car;
import uniProject.carShowroomManagementSystem.entity.concrete.Color;
import uniProject.carShowroomManagementSystem.entity.dto.CarDto;

@Service
public class CarManager implements CarService{

	private CarDao carDao;
	private BrandService brandService;
	private ColorService colorService;
	
	@Autowired
	public CarManager(CarDao carDao, BrandService brandService, ColorService colorService) {
		this.carDao = carDao;
		this.brandService = brandService;
		this.colorService = colorService;
	}
	
	//polymorphism: inheritance yoluyla
	@Override
	public Result add(CarDto entity) {
		Car car = new Car();
		
		car.setName(entity.getName());
		car.setDescription(entity.getDescription());
		car.setPrice(entity.getPrice());
		car.setSaleCount(0);//araba yeni eklendigi icin satisi henuz yapilmadi
		
		Brand brand = brandService.getById(entity.getBrandId()).getData();
		car.setBrand(brand);
		
		Color color = colorService.getById(entity.getColorId()).getData();
		car.setCarColor(color);
		
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
