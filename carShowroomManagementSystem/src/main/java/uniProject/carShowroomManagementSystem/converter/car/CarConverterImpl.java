package uniProject.carShowroomManagementSystem.converter.car;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.dto.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

@Component
@RequiredArgsConstructor
public class CarConverterImpl implements CarConverter{
	
	private final BrandService brandService;
	private final ColorService colorService;
	
	@Override
	public Car toCar(CreateCarRequestDto createCarRequestDto) {
		Car car = new Car();
		car.setBrand(brandService.getById(createCarRequestDto.getBrandId()).getData());
		car.setCarColor(colorService.getById(createCarRequestDto.getColorId()).getData());
		car.setDescription(createCarRequestDto.getDescription());
		car.setName(createCarRequestDto.getName());
		car.setPrice(createCarRequestDto.getPrice());
		car.setSaleCount(0);//araba, sisteme kaydedilme asamasainda, dolayisiyla satisi sifir
		return car;
	}
}
