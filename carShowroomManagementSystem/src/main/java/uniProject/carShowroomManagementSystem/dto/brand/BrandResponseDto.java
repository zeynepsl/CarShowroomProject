package uniProject.carShowroomManagementSystem.dto.brand;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;

@Getter
@Setter
public class BrandResponseDto implements GetDto{
	int id;
	String name;
}
