package uniProject.carShowroomManagementSystem.converter.car;

import java.util.Set;

import uniProject.carShowroomManagementSystem.dto.car.CarResponseDto;
import uniProject.carShowroomManagementSystem.dto.car.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

public interface CarConverter {

	Car toCar(CreateCarRequestDto createCarRequestDto);

	CarResponseDto toCarResponseDto(Car car);
	
	Set<CarResponseDto> toCarResponseDtoSet(Set<Car> cars);

}
