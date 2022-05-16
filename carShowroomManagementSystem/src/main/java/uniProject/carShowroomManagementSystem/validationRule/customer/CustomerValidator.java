package uniProject.carShowroomManagementSystem.validationRule.customer;

import uniProject.carShowroomManagementSystem.entity.Customer;
import uniProject.carShowroomManagementSystem.exception.BaseException;

public interface CustomerValidator {
	void validate(Customer customer) throws BaseException;
}
