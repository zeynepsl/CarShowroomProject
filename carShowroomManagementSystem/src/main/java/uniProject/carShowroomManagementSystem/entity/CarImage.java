package uniProject.carShowroomManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CarImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String url;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
}
