package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Color;

public interface ColorService extends BaseService<Color>{
	DataResult<List<Color>> findByName(String name);
}
