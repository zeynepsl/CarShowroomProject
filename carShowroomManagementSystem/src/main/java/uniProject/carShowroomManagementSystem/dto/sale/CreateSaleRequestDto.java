package uniProject.carShowroomManagementSystem.dto.sale;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
@Validated
public class CreateSaleRequestDto implements CreateDto{
	@NotNull(message = "car id of sale cannot be null")
	private int carId;
	
	@NotNull(message = "customer id of sale cannot be null")
	private int customerId;
}
