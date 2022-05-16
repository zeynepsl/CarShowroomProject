package uniProject.carShowroomManagementSystem.business;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;
import uniProject.carShowroomManagementSystem.entity.Customer;
import uniProject.carShowroomManagementSystem.exception.BaseException;

public interface CustomerService extends BaseService<Customer>,
                                         AddService<CreateCustomerRequestDto>, 
                                         GetService<CustomerResponseDto>, GetAllService<List<CustomerResponseDto>>{
	
	List<CustomerResponseDto> toCustomerResponseDtoList(List<Customer> customers);
	DataResult<CustomerResponseDto> findByEmail(String email) throws BaseException;
}
