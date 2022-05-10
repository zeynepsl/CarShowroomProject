package uniProject.carShowroomManagementSystem.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Getter
@Setter
public class CreateTestDriveRequestDto implements Dto{
	private int carId;
	private int customerId;
	private LocalDate testDate;
	private boolean isConfirm;
}
