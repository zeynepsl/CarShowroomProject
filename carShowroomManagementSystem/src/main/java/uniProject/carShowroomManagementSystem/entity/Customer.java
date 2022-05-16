package uniProject.carShowroomManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

import uniProject.carShowroomManagementSystem.core.entity.User;

//@EqualsAndHashCode(callSuper = false)

@Entity
@Getter
@Setter
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User{
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;*/
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(
			mappedBy = "customer",
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Sale> sales = new ArrayList<Sale>();
	
	public Customer addSale(Sale sale) {
		sales.add(sale);
		sale.setCustomer(this);
		return this;
	}
	
	public Customer removeSale(Sale sale) {
		sales.remove(sale);
		sale.setCustomer(null);
		return this;
	}
	
	//The testDrives collection is mapped using the @OneToMany annotation
	/* mappedBy attribute instructs the JPA provider that 
	 * the customer property in the TestDrive child entity manages the underlying Foreign Key column.*/
	//cascade all type sayesinde bir customer oluştururken ilgili customer a testDrive (lar) da eklersem
	//testdrive ı hibernate ile db ya kaydetme yapmadığım halde
	//customer oluştururken o customer a atadığım(o an yeni oluşturuyoruz) testDrive ları da db ye kaydedecektir
	
	@OneToMany(
			mappedBy = "customer", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<TestDrive> testDrives = new ArrayList<TestDrive>();
	
	public Customer addTestDrive(TestDrive testDrive) {
		testDrives.add(testDrive);
		testDrive.setCustomer(this);
		return this;
	}
	
	public Customer removeTestDrive(TestDrive testDrive) {
		testDrives.remove(testDrive);
		testDrive.setCustomer(null);
		return this;
	}
}
