package uniProject.carShowroomManagementSystem.converter.car;

import uniProject.carShowroomManagementSystem.dto.CreateCarRequestDto;
import uniProject.carShowroomManagementSystem.entity.Car;

public interface CarConverter {

	Car toCar(CreateCarRequestDto createCarRequestDto);

}
