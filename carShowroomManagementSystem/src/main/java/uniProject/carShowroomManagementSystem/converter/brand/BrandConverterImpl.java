package uniProject.carShowroomManagementSystem.converter.brand;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.brand.BrandResponseDto;
import uniProject.carShowroomManagementSystem.dto.brand.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

@Component
public class BrandConverterImpl implements BrandConverter{
	@Override
	public Brand toBrand(CreateBrandRequestDto createBrandRequestDto) {
		Brand brand = new Brand();
		brand.setName(createBrandRequestDto.getName());
		return brand;
	}
	
	@Override
	public BrandResponseDto toBrandResponseDto(Brand brand) {
		BrandResponseDto brandResponseDto = new BrandResponseDto();
		brandResponseDto.setId(brand.getId());
		brandResponseDto.setName(brand.getName());
		return brandResponseDto;
	}
}
