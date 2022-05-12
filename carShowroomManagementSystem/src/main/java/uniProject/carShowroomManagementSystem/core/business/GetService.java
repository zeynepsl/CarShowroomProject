package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.entity.GetDto;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;

@SuppressWarnings("hiding")
public interface GetService<GetDto> {
	DataResult<GetDto> get(int id);
}
