package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	List<Customer> findByBirthDateAfter(LocalTime birthDate);
	List<Customer> findByBirthDateBefore(LocalTime birthDate);
}
