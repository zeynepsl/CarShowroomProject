package uniProject.carShowroomManagementSystem.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "testDrives")
@AllArgsConstructor
@NoArgsConstructor

public class TestDrive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_drive_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
	//testdate must be a date in the future or present.
	@Column(name = "test_date", nullable = false)
	@FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	private LocalDate testDate;
	
}
