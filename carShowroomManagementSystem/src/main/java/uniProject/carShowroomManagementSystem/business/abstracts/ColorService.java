package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.CreateColorRequestDto;
import uniProject.carShowroomManagementSystem.entity.Color;

public interface ColorService extends BaseService<Color>, AddService<CreateColorRequestDto>{
	DataResult<List<Color>> findByName(String name);
}
