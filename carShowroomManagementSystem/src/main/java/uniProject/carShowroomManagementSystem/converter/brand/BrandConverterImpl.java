package uniProject.carShowroomManagementSystem.converter.brand;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.CreateBrandRequestDto;
import uniProject.carShowroomManagementSystem.entity.Brand;

@Component
public class BrandConverterImpl implements BrandConverter{
	@Override
	public Brand toBrand(CreateBrandRequestDto createBrandRequestDto) {
		Brand brand = new Brand();
		brand.setName(createBrandRequestDto.getName());
		return brand;
	}
}
