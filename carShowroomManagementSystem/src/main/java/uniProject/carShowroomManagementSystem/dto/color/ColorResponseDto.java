package uniProject.carShowroomManagementSystem.dto.color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColorResponseDto implements GetDto{
	int id;
	String name;
}
