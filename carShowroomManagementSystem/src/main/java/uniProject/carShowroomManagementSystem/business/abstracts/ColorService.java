package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Color;
import uniProject.carShowroomManagementSystem.entities.dtos.ColorDto;

public interface ColorService extends BaseService<Color>, AddService<ColorDto>{
	DataResult<List<Color>> findByName(String name);
}
