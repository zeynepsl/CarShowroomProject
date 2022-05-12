package uniProject.carShowroomManagementSystem.dto.brand;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@Validated
public class CreateBrandRequestDto implements CreateDto{

	@NotBlank(message = "brand name must not be null and its length must be greater than zero. ")
	String name;
}
