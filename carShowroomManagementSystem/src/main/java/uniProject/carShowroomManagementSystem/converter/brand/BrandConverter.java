package uniProject.carShowroomManagementSystem.converter.brand;

import uniProject.carShowroomManagementSystem.dto.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

public interface BrandConverter {

	Brand toBrand(CreateBrandRequestDto createBrandRequestDto);
	
}
