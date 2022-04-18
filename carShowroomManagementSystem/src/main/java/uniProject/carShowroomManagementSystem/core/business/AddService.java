package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.entity.Dto;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;

//sen ancak DTo tipindeki nesnelerle calisabilirsin:
@SuppressWarnings("hiding")
public interface AddService<Dto> {
	Result add(Dto entity);
}
