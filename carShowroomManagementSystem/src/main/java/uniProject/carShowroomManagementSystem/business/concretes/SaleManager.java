package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.business.abstracts.SaleService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Sale;

public class SaleManager implements SaleService{

	@Override
	public Result add(Sale entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Sale entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Sale> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> findByIsConfirmTrue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> findByIsConfirmFalse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> findBySaleDate(LocalTime saleDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> findAllByCustomer_Id(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Sale>> findByCar_Id(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
