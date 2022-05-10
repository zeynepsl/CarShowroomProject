package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

public interface BrandService extends BaseService<Brand>, AddService<CreateBrandRequestDto>{
	DataResult<List<Brand>> findByName(String name);
}
