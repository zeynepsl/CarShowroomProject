package uniProject.carShowroomManagementSystem.validationRule.color;

import uniProject.carShowroomManagementSystem.exception.BaseException;

public interface ColorValidator {
	void colorExist(String brandName) throws BaseException;
}
