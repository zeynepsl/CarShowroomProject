package uniProject.carShowroomManagementSystem.converter.carimage;

import org.springframework.stereotype.Component;

import uniProject.carShowroomManagementSystem.dto.carimage.CarImageResponseDto;
import uniProject.carShowroomManagementSystem.dto.carimage.CreateCarImageDto;
import uniProject.carShowroomManagementSystem.entity.Car;
import uniProject.carShowroomManagementSystem.entity.CarImage;

@Component
public class CarImageConverterImpl implements CarImageConverter{
	@Override
	public CarImage toCarImage(CreateCarImageDto createCarImageDto) {
		CarImage carImage = new CarImage();
		
		Car car = new Car();
		car.setId(createCarImageDto.getCarId());
		carImage.setCar(car);
		
		carImage.setName(createCarImageDto.getName());
		carImage.setUrl(createCarImageDto.getUrl());
		
		return carImage;
	}
	
	@Override
	public CarImageResponseDto toCarImageResponseDto(CarImage carImage) {
		CarImageResponseDto carImageResponseDto = new CarImageResponseDto();
		carImageResponseDto.setCarId(carImage.getCar().getId());
		carImageResponseDto.setName(carImage.getName());
		carImageResponseDto.setUrl(carImage.getUrl());
		return carImageResponseDto;
	}
}
