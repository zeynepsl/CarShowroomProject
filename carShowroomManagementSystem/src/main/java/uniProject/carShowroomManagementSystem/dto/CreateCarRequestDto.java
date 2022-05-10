package uniProject.carShowroomManagementSystem.dto;


import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Getter
@Setter
public class CreateCarRequestDto implements Dto{
	private String name;
	//modelYear
	private double price;
	private String description;
	private int colorId;
	private int brandId;
}
