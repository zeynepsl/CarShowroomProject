package uniProject.carShowroomManagementSystem.converter.carimage;

import uniProject.carShowroomManagementSystem.dto.carimage.CarImageResponseDto;
import uniProject.carShowroomManagementSystem.dto.carimage.CreateCarImageDto;
import uniProject.carShowroomManagementSystem.entity.CarImage;

public interface CarImageConverter {

	CarImage toCarImage(CreateCarImageDto createCarImageDto);

	CarImageResponseDto toCarImageResponseDto(CarImage carImage);

}
