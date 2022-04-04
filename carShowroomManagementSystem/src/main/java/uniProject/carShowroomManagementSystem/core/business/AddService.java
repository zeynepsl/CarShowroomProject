package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.entities.Dto;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;

//sen ancak DTo tipindeki nesnelerle calisabilirsin:
@SuppressWarnings("hiding")
public interface AddService<Dto> {
	Result add(Dto entity);
}
