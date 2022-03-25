package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import uniProject.carShowroomManagementSystem.business.abstracts.CarService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.core.utilities.results.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.CarDao;
import uniProject.carShowroomManagementSystem.entities.concretes.Car;

public class CarManager implements CarService{

	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		this.carDao = carDao;
	}
	
	@Override
	public Result add(Car entity) {
		carDao.save(entity);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
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
		Optional<Car> car = carDao.findById(id);
		return null;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameStartingWith(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameEndingWith(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameContaining(String infix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameLike(String likePattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameOrderByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByNameOrderByNameAsc(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByPriceLessThanEqual(Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByPriceGreaterThanEqual(Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Car>> findByPriceBetween(Double startPrice, Double endPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}
