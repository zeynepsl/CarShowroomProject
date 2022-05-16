package uniProject.carShowroomManagementSystem.validationRule.brand;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.exception.BaseException;
import uniProject.carShowroomManagementSystem.exception.BaseValidationException;

@Component
@RequiredArgsConstructor
public class BrandValidatorImpl implements BrandValidator{
	private final BrandService brandService;
	
	@Override
	public void brandExist(String brandName) throws BaseException {
		if(!brandService.findByName(brandName).getData().isEmpty()) {
			throw new BaseValidationException.BrandAlreadyExistsException("brand already exists");
		}
	}
}
