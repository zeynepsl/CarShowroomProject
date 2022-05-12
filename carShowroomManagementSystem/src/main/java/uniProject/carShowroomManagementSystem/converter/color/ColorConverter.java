package uniProject.carShowroomManagementSystem.converter.color;

import uniProject.carShowroomManagementSystem.dto.color.ColorResponseDto;
import uniProject.carShowroomManagementSystem.dto.color.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

public interface ColorConverter {

	Color toColor(CreateColorRequestDto createColorRequestDto);

	ColorResponseDto toColorResponseDto(Color color);


}
