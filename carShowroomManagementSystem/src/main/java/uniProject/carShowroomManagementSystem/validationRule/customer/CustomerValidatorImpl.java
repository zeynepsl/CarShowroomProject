package uniProject.carShowroomManagementSystem.validationRule.customer;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CustomerService;
import uniProject.carShowroomManagementSystem.entity.Customer;
import uniProject.carShowroomManagementSystem.exception.BaseException;

@Component
@RequiredArgsConstructor
public class CustomerValidatorImpl implements CustomerValidator{

	@Override
	public void validate(Customer customer) throws BaseException {
		// TODO Auto-generated method stub
		
	}
	
}
