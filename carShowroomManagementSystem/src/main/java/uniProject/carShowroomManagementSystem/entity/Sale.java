package uniProject.carShowroomManagementSystem.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
	public boolean getIsConfirm() {
		return isConfirm;
	}
	
	public void setIsConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}


	@Getter
	@Setter
	@Column(name = "price")
	private double price;
	
	@Getter
	@Setter
	@Column(name = "sale_date")
	private LocalDate saleDate;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	
}
