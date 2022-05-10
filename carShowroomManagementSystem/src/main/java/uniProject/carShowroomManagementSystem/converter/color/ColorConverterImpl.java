package uniProject.carShowroomManagementSystem.converter.color;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

@Component
public class ColorConverterImpl implements ColorConverter{
	@Override
	public Color toColor(CreateColorRequestDto createColorRequestDto) {
		Color color = new Color();
		color.setName(createColorRequestDto.getName());
		return color;
	}
}
