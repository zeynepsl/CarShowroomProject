package uniProject.carShowroomManagementSystem.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "brand")
	List<Car> cars;
}
