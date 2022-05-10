package uniProject.carShowroomManagementSystem.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "colors")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializier", "handler", "cars"})

public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_id")
	private int id;
	
	@Column(name = "name", nullable = false)
	@Size(min = 3, max = 10)
	private String name;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "carColor")
	private List<Car> cars;
}
