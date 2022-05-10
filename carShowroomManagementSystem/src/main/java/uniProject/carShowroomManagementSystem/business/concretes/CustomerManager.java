package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.CustomerDao;
import uniProject.carShowroomManagementSystem.entity.concrete.Customer;
import uniProject.carShowroomManagementSystem.dto.CustomerDto;

@Service
public class CustomerManager implements CustomerService{
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Result add(CustomerDto entity) {
		Customer customer = new Customer();
		customer.setEmail(entity.getEmail());
		customer.setFirstName(entity.getFirstName());
		customer.setLastName(entity.getLastName());
		customer.setUsername(entity.getUsername());
		customer.setPhoneNumber(entity.getPhoneNUmber());
		customer.setPassword(entity.getPassword());
		customerDao.save(customer);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
		Customer customer = getById(id).getData();
		if(customer == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		customerDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Customer entity) {
		customerDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<Customer> getById(int id) {
		Customer customer = customerDao.findById(id).orElse(null);
		if(customer == null) {
			return new ErrorDataResult<Customer>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Customer>(customer, Messages.viewed);
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(customerDao.findAll(), Messages.listed);
	}


}
