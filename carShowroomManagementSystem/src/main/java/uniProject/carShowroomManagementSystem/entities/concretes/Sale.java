package uniProject.carShowroomManagementSystem.entities.concretes;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor

public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id")
	private int id;
	
	private int carId;
	private int customerId;
	
	@Column(name = "sale_date", nullable = false)
	@FutureOrPresent
	private LocalTime saleDate;
}
