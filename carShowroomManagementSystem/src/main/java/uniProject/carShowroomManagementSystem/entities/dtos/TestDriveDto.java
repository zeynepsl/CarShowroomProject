package uniProject.carShowroomManagementSystem.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entities.Dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestDriveDto implements Dto{
	private int carId;
	private int customerId;
	private LocalDate testDate;
	private boolean isConfirm;
}
