package uniProject.carShowroomManagementSystem.business;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.entity.User;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;

public interface UserService extends BaseService<User>{
	public DataResult<User> findByEmail(String email);
}
