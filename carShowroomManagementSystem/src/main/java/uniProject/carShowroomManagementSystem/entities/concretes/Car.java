package uniProject.carShowroomManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor

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
	@NotNull
	@Size(min = 3, max = 10)
	private String name;
	
	//modelYear
	
	@Column(name = "price", nullable = false)
	@Positive
	private double price;
	
	@Column(name = "description", nullable = false)
	@Size(min = 3, max = 30)
	private String description;
	
	@OneToOne(mappedBy = "car")
	private Sale sale;
	
	@OneToMany(mappedBy = "car")
	private List<TestDrive> testDrives;
}
