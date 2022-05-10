package uniProject.carShowroomManagementSystem.converter.customer;

import uniProject.carShowroomManagementSystem.dto.CreateCustomerRequestDto;
import uniProject.carShowroomManagementSystem.entity.Customer;

public interface CustomerConverter {

	Customer toCustomer(CreateCustomerRequestDto createCustomerRequestDto);

}
