package uniProject.carShowroomManagementSystem.dto.carimage;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.CreateDto;

@Getter
@Setter
public class CreateCarImageDto implements CreateDto{
	private String url;
	private String name;
	private int carId;
}
