package uniProject.carShowroomManagementSystem.dto.car;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@Validated
public class CreateCarRequestDto implements CreateDto{
	@NotBlank(message = "brand name must not be null and its length must be greater than zero. ")
	private String name;
	
	@NotNull(message = "model year of car cannot be null")
	private int modelYear;
	
	@NotNull(message = "model year of car cannot be null")
	private double price;
	
	@NotBlank(message = "description must not be null and its length must be greater than zero. ")
	private String description;
	
	@NotNull(message = "color id of car cannot be null")
	private int colorId;
	
	@NotNull(message = "barnd id of car cannot be null")
	private int brandId;
}
