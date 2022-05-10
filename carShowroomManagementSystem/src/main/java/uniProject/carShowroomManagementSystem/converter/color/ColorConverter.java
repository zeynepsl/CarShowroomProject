package uniProject.carShowroomManagementSystem.converter.color;

import uniProject.carShowroomManagementSystem.dto.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

public interface ColorConverter {

	Color toColor(CreateColorRequestDto createColorRequestDto);


}
