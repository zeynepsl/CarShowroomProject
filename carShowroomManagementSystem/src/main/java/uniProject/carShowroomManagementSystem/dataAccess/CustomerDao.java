package uniProject.carShowroomManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	/*List<Customer> findByBirthDateAfter(LocalDate birthDate);
	List<Customer> findByBirthDateBefore(LocalDate birthDate);*/

}
