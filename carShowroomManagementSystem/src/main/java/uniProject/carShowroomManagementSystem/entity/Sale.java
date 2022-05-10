package uniProject.carShowroomManagementSystem.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter
@Setter
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
