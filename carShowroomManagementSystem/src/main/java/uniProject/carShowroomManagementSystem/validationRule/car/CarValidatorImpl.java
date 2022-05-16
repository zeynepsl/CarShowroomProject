package uniProject.carShowroomManagementSystem.validationRule.car;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.exception.BaseException;

@Component
public class CarValidatorImpl implements CarValidator{
	@Override
	public void validate(Car input) throws BaseException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void entityExist(String input) throws BaseException {
		
	}
}
