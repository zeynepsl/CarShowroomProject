package uniProject.carShowroomManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id")
	private Color carColor;
	
	@Column(name = "name", nullable = false)
	//@Size(min = 3, max = 10)
	private String name;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "sale_count")
	private int saleCount;
	
	@OneToMany(
			mappedBy = "car", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Sale> sales = new ArrayList<Sale>();
	
	public Car addSale(Sale sale) {
		sales.add(sale);
		sale.setCar(this);
		return this;
	}
	
	public Car removeSale(Sale sale) {
		sales.remove(sale);
		sale.setCar(null);
		return this;
	}
	
	@OneToMany(
			mappedBy = "car",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<TestDrive> testDrives = new ArrayList<TestDrive>();
	
	public Car addTesDrive(TestDrive testDrive) {
		testDrives.add(testDrive);
		testDrive.setCar(this);
		return this;
	}
	
	public Car removeTestDrive(TestDrive testDrive) {
		testDrives.remove(testDrive);
		testDrive.setCar(null);
		return this;
	}
	
	@OneToMany(
			mappedBy = "car",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<CarImage> carImages = new ArrayList<CarImage>();
	
	public Car addImage(CarImage carImage) {
		carImages.add(carImage);
		carImage.setCar(this);
		return this;
	}
	
	public Car removeImage(CarImage carImage) {
		carImages.remove(carImage);
		carImage.setCar(null);
		return this;
	}
}
