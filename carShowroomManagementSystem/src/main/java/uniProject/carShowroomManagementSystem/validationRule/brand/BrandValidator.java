package uniProject.carShowroomManagementSystem.validationRule.brand;

import uniProject.carShowroomManagementSystem.exception.BaseException;

public interface BrandValidator {
	void brandExist(String brandName) throws BaseException;
}
