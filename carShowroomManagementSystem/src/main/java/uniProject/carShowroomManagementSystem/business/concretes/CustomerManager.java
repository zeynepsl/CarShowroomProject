package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.Customer;

public class CustomerManager implements CustomerService{

	@Override
	public Result add(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Customer> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Customer>> findByBirthDateAfter(LocalTime birthDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Customer>> findByBirthDateBefore(LocalTime birthDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
