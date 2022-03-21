package uniProject.carShowroomManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
	
	@OneToMany(mappedBy = "carColor")
	private List<Car> cars;
}
