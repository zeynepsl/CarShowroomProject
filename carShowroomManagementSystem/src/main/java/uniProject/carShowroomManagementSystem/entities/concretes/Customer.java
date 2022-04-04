package uniProject.carShowroomManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entities.User;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializier", "handler", "sales"})
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Sale> sales;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<TestDrive> testDrives;*/
}
