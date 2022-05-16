package uniProject.carShowroomManagementSystem.validationRule;

import uniProject.carShowroomManagementSystem.exception.BaseException;

public interface Validator<T> {
	void validate(T input) throws BaseException;
	void entityExist(String input) throws BaseException;
}
