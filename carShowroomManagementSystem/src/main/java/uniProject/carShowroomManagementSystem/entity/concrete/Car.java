package uniProject.carShowroomManagementSystem.entity.concrete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializier", "handler", "sales"})

public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color carColor;
	
	@Column(name = "name", nullable = false)
	//@Size(min = 3, max = 10)
	private String name;
	
	//modelYear
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "car")
	private List<Sale> sales;
	
	@Column(name = "sale_count")
	private int saleCount;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "car")
	private List<TestDrive> testDrives;*/
}
