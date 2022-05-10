package uniProject.carShowroomManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Getter
@Setter
public class CreateRoleRequestDto implements Dto{
	String name;
}
