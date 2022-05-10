package uniProject.carShowroomManagementSystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestDriveDto implements Dto{
	private int carId;
	private int customerId;
	private LocalDate testDate;
	private boolean isConfirm;
}
