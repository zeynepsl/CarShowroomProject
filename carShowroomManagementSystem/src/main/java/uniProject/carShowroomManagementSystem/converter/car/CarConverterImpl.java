package uniProject.carShowroomManagementSystem.converter.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.BrandService;
import uniProject.carShowroomManagementSystem.business.abstracts.ColorService;
import uniProject.carShowroomManagementSystem.converter.sale.SaleConverter;
import uniProject.carShowroomManagementSystem.converter.testdrive.TestDriveConverter;
import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.car.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.Car;

@Component
@RequiredArgsConstructor
public class CarConverterImpl implements CarConverter{
	
	private final BrandService brandService;
	private final ColorService colorService;
	private final SaleConverter saleConverter;
	private final TestDriveConverter testDriveConverter;
	
	@Override
	public Car toCar(CreateCarRequestDto createCarRequestDto) {
		Car car = new Car();
		car.setBrand(brandService.getById(createCarRequestDto.getBrandId()).getData());
		car.setCarColor(colorService.getById(createCarRequestDto.getColorId()).getData());
		car.setDescription(createCarRequestDto.getDescription());
		car.setName(createCarRequestDto.getName());
		car.setPrice(createCarRequestDto.getPrice());
		car.setSaleCount(0);//araba, sisteme kaydedilme asamasainda, dolayisiyla satisi sifir
		car.setModelYear(createCarRequestDto.getModelYear());
		return car;
	}
	
	@Override
	public CarResponseDto toCarResponseDto(Car car) {
		CarResponseDto carResponseDto = new CarResponseDto();
		carResponseDto.setId(car.getId());
		carResponseDto.setBrandId(car.getBrand().getId());
		carResponseDto.setColorId(car.getCarColor().getId());
		carResponseDto.setDescription(car.getDescription());
		carResponseDto.setModelYear(car.getModelYear());
		carResponseDto.setName(car.getName());
		carResponseDto.setPrice(car.getPrice());
		carResponseDto.setSaleCount(car.getSaleCount());
		
		List<SaleResponseDto> saleResponseDtos = new ArrayList<SaleResponseDto>();
		car.getSales().forEach(sale -> {
			SaleResponseDto saleResponseDto = saleConverter.toSaleResponseDto(sale);
			saleResponseDtos.add(saleResponseDto);
		});
		carResponseDto.setSales(saleResponseDtos);
		
		List<TestDriveResponseDto> testDriveResponseDtos = new ArrayList<TestDriveResponseDto>();
		car.getTestDrives().forEach(testDrive -> {
			TestDriveResponseDto testDriveResponseDto = testDriveConverter.toTestDriveResponseDto(testDrive);
			testDriveResponseDtos.add(testDriveResponseDto);
		});
		carResponseDto.setTestDrives(testDriveResponseDtos);
		
		return carResponseDto;
	}
	
	@Override
	public Set<CarResponseDto> toCarResponseDtoSet(Set<Car> cars) {
		Set<CarResponseDto> carResponseDtos = new HashSet<CarResponseDto>();
		cars.forEach(car -> {
			CarResponseDto carResponseDto = toCarResponseDto(car);
			carResponseDtos.add(carResponseDto);
		});
		return carResponseDtos;
	}
}
