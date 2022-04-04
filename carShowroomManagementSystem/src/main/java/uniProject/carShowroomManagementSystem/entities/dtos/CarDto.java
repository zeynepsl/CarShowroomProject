package uniProject.carShowroomManagementSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entities.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarDto implements Dto{
	private String name;
	//modelYear
	private double price;
	private String description;
	private int colorId;
	private int brandId;
}
