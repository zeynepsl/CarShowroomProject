package uniProject.carShowroomManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "colors")
@AllArgsConstructor
@NoArgsConstructor
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_id")
	private int id;
	
	@Column(name = "name", nullable = false)
	@Size(min = 3, max = 10)
	private String name;
	
	@OneToMany(
			mappedBy = "carColor",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Car> cars = new ArrayList<Car>();
	
	public Color addCar(Car car) {
		cars.add(car);
		car.setCarColor(this);
		return this;
	}
	
	public Color removeCar(Car car) {
		cars.remove(car);
		car.setCarColor(null);
		return this;
	}

}
