package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.color.ColorResponseDto;
import uniProject.carShowroomManagementSystem.dto.color.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

public interface ColorService extends BaseService<Color>, 
                                      AddService<CreateColorRequestDto>, 
                                      GetService<ColorResponseDto>, GetAllService<List<ColorResponseDto>>{
	
	List<ColorResponseDto> toColorResponseDtoLis(List<Color> colors);
	
	DataResult<List<ColorResponseDto>> findByName(String name);
}
