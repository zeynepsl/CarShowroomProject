package uniProject.carShowroomManagementSystem.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Getter
@Setter
public class CreateBrandRequestDto implements Dto{

	@NotNull
	String name;
}
