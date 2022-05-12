package uniProject.carShowroomManagementSystem.dto.customer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;
import uniProject.carShowroomManagementSystem.dto.sale.SaleResponseDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;

@Getter
@Setter
public class CustomerResponseDto implements GetDto{
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userName;
	private String email;
	private List<SaleResponseDto> sales = new ArrayList<SaleResponseDto>();
	private List<TestDriveResponseDto> testDrives = new ArrayList<TestDriveResponseDto>();
}
