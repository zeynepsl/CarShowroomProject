package uniProject.carShowroomManagementSystem.dto.carimage;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;

@Getter
@Setter
public class CarImageResponseDto implements GetDto{
	private int id;
	private String url;
	private String name;
	private int carId;
}
