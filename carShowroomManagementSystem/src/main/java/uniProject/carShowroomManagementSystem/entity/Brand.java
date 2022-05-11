package uniProject.carShowroomManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializier", "handler", "cars"})
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private int id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@JsonIgnore
	@OneToMany(
			mappedBy = "brand", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	List<Car> cars = new ArrayList<Car>();
	
	public Brand addCar(Car car) {
		cars.add(car);
		car.setBrand(this);
		return this;
	}
	
	public Brand removeCar(Car car) {
		cars.remove(car);
		car.setBrand(null);
		return this;
	}
}
