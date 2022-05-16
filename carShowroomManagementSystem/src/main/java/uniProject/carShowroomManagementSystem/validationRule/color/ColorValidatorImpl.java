package uniProject.carShowroomManagementSystem.validationRule.color;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.exception.BaseException;
import uniProject.carShowroomManagementSystem.exception.BaseValidationException;

@Component
@RequiredArgsConstructor
public class ColorValidatorImpl implements ColorValidator{
	private final ColorService colorService;
	
	@Override
	public void colorExist(String brandName) throws BaseException {
		if(!colorService.findByName(brandName).getData().isEmpty()) {
			throw new BaseValidationException.ColorAlreadyExistsException("color already exists");
		}
	}
}
