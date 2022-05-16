package uniProject.carShowroomManagementSystem.entity;

import java.time.LocalDate;

import javax.persistence.*;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "sale_date", nullable = false)
	private LocalDate saleDate;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
}
