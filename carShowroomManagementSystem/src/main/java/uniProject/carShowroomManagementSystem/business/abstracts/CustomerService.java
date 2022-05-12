package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

public interface CustomerService extends BaseService<Customer>,
                                         AddService<CreateCustomerRequestDto>, 
                                         GetService<CustomerResponseDto>, GetAllService<List<CustomerResponseDto>>{
	
	List<CustomerResponseDto> toCustomerResponseDtoList(List<Customer> customers);
}
