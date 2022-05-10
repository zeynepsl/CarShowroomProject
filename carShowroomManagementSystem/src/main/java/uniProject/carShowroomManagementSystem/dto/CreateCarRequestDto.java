package uniProject.carShowroomManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarRequestDto implements Dto{
	private String name;
	//modelYear
	private double price;
	private String description;
	private int colorId;
	private int brandId;
}
