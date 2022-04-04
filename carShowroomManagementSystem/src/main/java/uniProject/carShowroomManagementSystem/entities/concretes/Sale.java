package uniProject.carShowroomManagementSystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "sale_date", nullable = false)
	private LocalDate saleDate;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
}
