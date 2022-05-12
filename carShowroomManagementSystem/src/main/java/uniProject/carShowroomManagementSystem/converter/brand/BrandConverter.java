package uniProject.carShowroomManagementSystem.converter.brand;

import uniProject.carShowroomManagementSystem.dto.brand.BrandResponseDto;
import uniProject.carShowroomManagementSystem.dto.brand.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

public interface BrandConverter {

	Brand toBrand(CreateBrandRequestDto createBrandRequestDto);

	BrandResponseDto toBrandResponseDto(Brand brand);
	
}
