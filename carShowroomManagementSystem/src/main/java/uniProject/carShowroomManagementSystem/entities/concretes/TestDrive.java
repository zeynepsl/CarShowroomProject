package uniProject.carShowroomManagementSystem.entities.concretes;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "testDrives")
@AllArgsConstructor
@NoArgsConstructor

public class TestDrive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_drive_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	//testdate must be a date in the future or present.
	@Column(name = "test_date", nullable = false)
	@FutureOrPresent
	private LocalTime testDate;
	
	@Column(name = "is_confirm_by_admin")
	private boolean isConfirmByAdmin;
	
}
