package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Brand;

public interface BrandService extends BaseService<Brand>{
	DataResult<List<Brand>> findByName(String name);
}
