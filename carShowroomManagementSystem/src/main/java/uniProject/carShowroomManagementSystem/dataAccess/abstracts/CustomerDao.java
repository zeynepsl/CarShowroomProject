package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entity.concrete.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	/*List<Customer> findByBirthDateAfter(LocalDate birthDate);
	List<Customer> findByBirthDateBefore(LocalDate birthDate);*/

}
