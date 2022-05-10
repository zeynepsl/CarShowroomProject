package uniProject.carShowroomManagementSystem.converter.customer;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

@Component
public class CustomerConverterImpl implements CustomerConverter{
	@Override
	public Customer toCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
		Customer customer = new Customer();
		customer.setEmail(createCustomerRequestDto.getEmail());
		customer.setFirstName(createCustomerRequestDto.getFirstName());
		customer.setLastName(createCustomerRequestDto.getLastName());
		customer.setPassword(createCustomerRequestDto.getPassword());
		customer.setPhoneNumber(createCustomerRequestDto.getPhoneNumber());
		customer.setUsername(createCustomerRequestDto.getUsername());
		return customer;
	}
}
