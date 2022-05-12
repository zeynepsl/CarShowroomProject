package uniProject.carShowroomManagementSystem.dto.color;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.*;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@Validated
public class CreateColorRequestDto implements CreateDto{
	
	@NotBlank(message = "color name must not be null and its length must be greater than zero. ")
	String name;
}
