package uniProject.carShowroomManagementSystem.converter.customer;

import uniProject.carShowroomManagementSystem.dto.customer.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

public interface CustomerConverter {

	Customer toCustomer(CreateCustomerRequestDto createCustomerRequestDto);

	CustomerResponseDto toCustomerResponseDto(Customer customer);

}
