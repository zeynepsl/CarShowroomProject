package uniProject.carShowroomManagementSystem.business.abstracts;

import java.util.List;

import uniProject.carShowroomManagementSystem.core.business.AddService;
import uniProject.carShowroomManagementSystem.core.business.BaseService;
import uniProject.carShowroomManagementSystem.core.business.GetAllService;
import uniProject.carShowroomManagementSystem.core.business.GetService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.brand.BrandResponseDto;
import uniProject.carShowroomManagementSystem.dto.brand.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

public interface BrandService extends BaseService<Brand>, 
                                      AddService<CreateBrandRequestDto>, 
                                      GetService<BrandResponseDto>, GetAllService<List<BrandResponseDto>>{
	
	List<BrandResponseDto> toBrandResponseDtoList(List<Brand> brands);
	 
	DataResult<List<BrandResponseDto>> findByName(String name);
}
