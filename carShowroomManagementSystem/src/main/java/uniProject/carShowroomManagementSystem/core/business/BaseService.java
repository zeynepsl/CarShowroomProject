package uniProject.carShowroomManagementSystem.core.business;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;


public interface BaseService<T> {
	Result delete(int id);
	Result update(T entity);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();
}
