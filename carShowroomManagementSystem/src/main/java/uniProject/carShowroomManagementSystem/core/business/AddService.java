package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.entity.CreateDto;
import uniProject.carShowroomManagementSystem.core.util.result.Result;

//sen ancak CreateDto tipindeki nesnelerle calisabilirsin:
@SuppressWarnings("hiding")
public interface AddService<CreateDto>{
	Result add(CreateDto entity);
}
