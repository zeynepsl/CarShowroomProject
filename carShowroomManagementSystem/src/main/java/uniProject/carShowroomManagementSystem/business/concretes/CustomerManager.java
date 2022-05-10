package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.customer.CustomerConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.CustomerDao;
import uniProject.carShowroomManagementSystem.dto.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService{
	
	private final CustomerDao customerDao;
	private final CustomerConverter customerConverter;

	@Override
	public Result add(CreateCustomerRequestDto createCustomerRequestDto) {
		Customer customer = customerConverter.toCustomer(createCustomerRequestDto);
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
