package uniProject.carShowroomManagementSystem.dto.car;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;

@Getter
@Setter
public class CarResponseDto implements GetDto{
	int id;
	private int brandId;
	private int colorId;
	private String name;
	private int modelYear;
	private double price;
	private String description;
	private int saleCount;
	
	private List<SaleResponseDto> sales = new ArrayList<SaleResponseDto>();
	private List<TestDriveResponseDto> testDrives = new ArrayList<TestDriveResponseDto>();
}
