package uniProject.carShowroomManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.TestDriveService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@RestController
@RequestMapping("api/testdrives")
@RequiredArgsConstructor
public class TestDriveController {
	private final TestDriveService testDriveService;
	
	@PostMapping("/")
	public Result add(@RequestBody CreateTestDriveRequestDto createTestDriveRequestDto) {
		return testDriveService.add(createTestDriveRequestDto);
	}

	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return testDriveService.delete(id);
	}

	@PutMapping("/")
	public Result update(TestDrive entity) {
		return testDriveService.update(entity);
	}

	@GetMapping("{id}")
	public DataResult<TestDrive> getById(@PathVariable int id) {
		return testDriveService.getById(id);
	}
	
	@PatchMapping("{testDriveId}")
	public Result confirmTestDrive(@PathVariable int testDriveId) {
		return testDriveService.confirmTestDrive(testDriveId);
	}

	@GetMapping("/")
	public DataResult<List<TestDrive>> getAll() {
		return testDriveService.getAll();
	}

	@GetMapping("/isConfirm")
	public DataResult<List<TestDrive>> findByIsConfirmTrue() {
		return testDriveService.findByIsConfirmTrue();
	}

	@GetMapping("/isNotConfirm")
	public DataResult<List<TestDrive>> findByIsConfirmFalse() {
		return testDriveService.findByIsConfirmFalse();
	}

	@GetMapping("/testDate")
	public DataResult<List<TestDrive>> findBytestDate(@RequestParam LocalDate testDate) {
		return testDriveService.findBytestDate(testDate);
	}

	@GetMapping("/customer/{customerId}")
	public DataResult<List<TestDrive>> findAllByCustomer_Id(@PathVariable int customerId) {
		return testDriveService.findAllByCustomer_Id(customerId);
	}

	@GetMapping("/car/{carId}")
	public DataResult<List<TestDrive>> findAllByCar_Id(@PathVariable int carId) {
		return testDriveService.findAllByCar_Id(carId);
	}
}
