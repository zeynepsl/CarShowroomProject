package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.entity.concrete.Brand;
import uniProject.carShowroomManagementSystem.dto.BrandDto;

public interface BrandService extends BaseService<Brand>, AddService<BrandDto>{
	DataResult<List<Brand>> findByName(String name);
}
