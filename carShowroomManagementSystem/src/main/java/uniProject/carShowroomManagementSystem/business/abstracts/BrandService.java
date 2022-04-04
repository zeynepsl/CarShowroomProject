package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.entities.concretes.Brand;
import uniProject.carShowroomManagementSystem.entities.dtos.BrandDto;

public interface BrandService extends BaseService<Brand>, AddService<BrandDto>{
	DataResult<List<Brand>> findByName(String name);
}
