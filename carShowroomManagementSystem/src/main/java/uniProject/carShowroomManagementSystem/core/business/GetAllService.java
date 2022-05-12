package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;

public interface GetAllService<T> {
	DataResult<T> getAll();
}
