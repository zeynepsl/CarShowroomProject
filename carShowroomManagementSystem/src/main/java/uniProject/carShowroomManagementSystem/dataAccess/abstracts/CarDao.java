package uniProject.carShowroomManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uniProject.carShowroomManagementSystem.entities.concretes.Car;

public interface CarDao extends JpaRepository<Car, Integer>{
	List<Car> findByName(String name);
	//extra: List<Car> findByNameIs(String name);
	//       List<Car> findByNameEquals(String name);
	
	List<Car> findByNameStartingWith(String prefix);
	List<Car> findByNameEndingWith(String suffix);
	List<Car> findByNameContaining(String infix);
	List<Car> findByNameLike(String likePattern);
	
	List<Car> findByNameOrderByName(String name);// Z -A
	List<Car> findByNameOrderByNameAsc(String name);// A - Z
	
	List<Car> findByPriceLessThanEqual(Double price);
	List<Car> findByPriceGreaterThanEqual(Double price);
	
	List<Car> findByPriceBetween(Double startPrice, Double endPrice);
	
}
