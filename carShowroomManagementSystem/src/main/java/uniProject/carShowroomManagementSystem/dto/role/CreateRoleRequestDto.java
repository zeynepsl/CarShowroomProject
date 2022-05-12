package uniProject.carShowroomManagementSystem.dto.role;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
public class CreateRoleRequestDto implements CreateDto{
	
	@NotBlank(message = "name must not be null and its length must be greater than zero. ")
	String name;
}
