package uniProject.carShowroomManagementSystem.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.CarService;
import uniProject.carShowroomManagementSystem.business.CustomerService;
import uniProject.carShowroomManagementSystem.business.TestDriveService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.testdrive.TestDriveConverter;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.TestDriveDao;
import uniProject.carShowroomManagementSystem.dto.testdrive.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.dto.testdrive.TestDriveResponseDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Service
@RequiredArgsConstructor
public class TestDriveManager implements TestDriveService{
	
	private final TestDriveDao testDriveDao;
	private final TestDriveConverter testDriveConverter;
	private final CarService carService;
	
	private final CustomerService customerService;


	@Override
	public Result add(CreateTestDriveRequestDto createTestDriveRequestDto) {
		TestDrive testDrive = testDriveConverter.toTestDrive(createTestDriveRequestDto);
		testDrive.setCar(carService.getById(createTestDriveRequestDto.getCarId()).getData());
		testDrive.setCustomer(customerService.getById(createTestDriveRequestDto.getCustomerId()).getData());

		testDriveDao.save(testDrive);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(int id) {
		TestDrive testDrive = getById(id).getData();
		if(testDrive == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		testDriveDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(TestDrive entity) {
		testDriveDao.save(entity);
		return new SuccessResult(Messages.updated);
	}

	@Override
	public DataResult<TestDrive> getById(int id) {
		TestDrive testDrive = testDriveDao.findById(id).orElse(null);
		if(testDrive == null) {
			return new ErrorDataResult<TestDrive>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<TestDrive>(testDrive, Messages.viewed);
	}
	
	@Override
	public DataResult<TestDriveResponseDto> get(int id) {
		TestDrive testDrive = getById(id).getData();
		if(testDrive == null) {
			return new ErrorDataResult<TestDriveResponseDto>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<TestDriveResponseDto>(testDriveConverter.toTestDriveResponseDto(testDrive), Messages.viewed);
	}
	
	@Override
	public Result confirmTestDrive(int testDriveId) {
		TestDrive testDrive = getById(testDriveId).getData();
		if(testDrive == null) {
			return new ErrorDataResult<TestDrive>(null, Messages.isNotExist);
		}
		if(testDrive.isConfirm()) {
			return new ErrorResult(Messages.alreadyConfirmed);
		}
		testDrive.setConfirm(true);
		testDriveDao.save(testDrive);
		return new SuccessResult(Messages.confirmedTestDrive);
	}

	@Override
	public List<TestDriveResponseDto> toTestDriveResponseDtoList(List<TestDrive> testDrives){
		List<TestDriveResponseDto> testDriveResponseDtos = new ArrayList<TestDriveResponseDto>();
		testDrives.forEach(testDrive -> {
			TestDriveResponseDto testDriveResponseDto = testDriveConverter.toTestDriveResponseDto(testDrive);
			testDriveResponseDtos.add(testDriveResponseDto);
		});
		return testDriveResponseDtos;
	}

	@Override
	public DataResult<List<TestDriveResponseDto>> getAll() {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findAll()), Messages.listed);
	}
	
	@Override
	public DataResult<List<TestDriveResponseDto>> findByIsConfirmTrue() {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findByIsConfirmTrue()), Messages.listed);
	}

	@Override
	public DataResult<List<TestDriveResponseDto>> findByIsConfirmFalse() {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findByIsConfirmFalse()), Messages.listed);
	}

	@Override
	public DataResult<List<TestDriveResponseDto>> findBytestDate(LocalDate testDate) {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findBytestDate(testDate)), Messages.listed);
	}

	@Override
	public DataResult<List<TestDriveResponseDto>> findAllByCustomer_Id(int customerId) {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findAllByCustomer_Id(customerId)), Messages.listed);
	}

	@Override
	public DataResult<List<TestDriveResponseDto>> findAllByCar_Id(int carId) {
		return new SuccessDataResult<List<TestDriveResponseDto>>(
				toTestDriveResponseDtoList(testDriveDao.findAllByCar_Id(carId)), Messages.listed);
	}

}
