package uniProject.carShowroomManagementSystem.dto.testdrive;

import java.time.LocalDate;

import lombok.Setter;
import uniProject.carShowroomManagementSystem.core.entity.GetDto;
import lombok.Getter;

@Getter
@Setter
public class TestDriveResponseDto implements GetDto{
	int id;
	private int customerId;
	private int carId;
	private boolean isConfirm;
	private LocalDate testDate;
}
