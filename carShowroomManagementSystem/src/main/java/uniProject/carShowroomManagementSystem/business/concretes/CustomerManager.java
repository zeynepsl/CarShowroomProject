package uniProject.carShowroomManagementSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.CustomerService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.customer.CustomerConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.CustomerDao;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;
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
	public DataResult<CustomerResponseDto> get(int id) {
		Customer customer = getById(id).getData();
		if(customer == null) {
			return new ErrorDataResult<CustomerResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<CustomerResponseDto>(customerConverter.toCustomerResponseDto(customer), Messages.viewed);
	}

	@Override
	public List<CustomerResponseDto> toCustomerResponseDtoList(List<Customer> customers){
		List<CustomerResponseDto> customerResponseDtos = new ArrayList<CustomerResponseDto>();
		customers.forEach(customer -> {
			CustomerResponseDto customerResponseDto = customerConverter.toCustomerResponseDto(customer);
			customerResponseDtos.add(customerResponseDto);
		});
		return customerResponseDtos;
	}

	
	@Override
	public DataResult<List<CustomerResponseDto>> getAll() {
		return new SuccessDataResult<List<CustomerResponseDto>>(
				toCustomerResponseDtoList(customerDao.findAll()), Messages.listed);
	}
	

}
