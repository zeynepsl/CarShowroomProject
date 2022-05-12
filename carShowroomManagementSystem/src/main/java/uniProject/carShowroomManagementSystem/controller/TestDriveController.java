package uniProject.carShowroomManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.TestDriveService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.dto.testdrive.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Validated
@RestController
@RequestMapping("api/testdrives")
@RequiredArgsConstructor
public class TestDriveController {
	private final TestDriveService testDriveService;
	
	@PostMapping("/")
	public Result add(@Valid @RequestBody CreateTestDriveRequestDto createTestDriveRequestDto) {
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
	public DataResult<TestDriveResponseDto> getById(@PathVariable int id) {
		return testDriveService.get(id);
	}
	
	@PatchMapping("{testDriveId}")
	public Result confirmTestDrive(@PathVariable int testDriveId) {
		return testDriveService.confirmTestDrive(testDriveId);
	}

	@GetMapping("/")
	public DataResult<List<TestDriveResponseDto>> getAll() {
		return testDriveService.getAll();
	}

	@GetMapping("/isConfirm")
	public DataResult<List<TestDriveResponseDto>> findByIsConfirmTrue() {
		return testDriveService.findByIsConfirmTrue();
	}

	@GetMapping("/isNotConfirm")
	public DataResult<List<TestDriveResponseDto>> findByIsConfirmFalse() {
		return testDriveService.findByIsConfirmFalse();
	}

	@GetMapping("/testDate")
	public DataResult<List<TestDriveResponseDto>> findBytestDate(@RequestParam LocalDate testDate) {
		return testDriveService.findBytestDate(testDate);
	}

	@GetMapping("/customer/{customerId}")
	public DataResult<List<TestDriveResponseDto>> findAllByCustomer_Id(@PathVariable int customerId) {
		return testDriveService.findAllByCustomer_Id(customerId);
	}

	@GetMapping("/car/{carId}")
	public DataResult<List<TestDriveResponseDto>> findAllByCar_Id(@PathVariable int carId) {
		return testDriveService.findAllByCar_Id(carId);
	}
}
