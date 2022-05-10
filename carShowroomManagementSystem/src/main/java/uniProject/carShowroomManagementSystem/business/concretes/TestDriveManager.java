package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.abstracts.TestDriveService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.testdrive.TestDriveConverter;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.TestDriveDao;
import uniProject.carShowroomManagementSystem.dto.CreateTestDriveRequestDto;
import uniProject.carShowroomManagementSystem.entity.TestDrive;

@Service
@RequiredArgsConstructor
public class TestDriveManager implements TestDriveService{
	
	private final TestDriveDao testDriveDao;
	private final TestDriveConverter testDriveConverter;


	@Override
	public Result add(CreateTestDriveRequestDto createTestDriveRequestDto) {
		TestDrive testDrive = testDriveConverter.toTestDrive(createTestDriveRequestDto);
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
	public DataResult<List<TestDrive>> getAll() {
		return new SuccessDataResult<List<TestDrive>>(testDriveDao.findAll(), Messages.listed);
	}

	@Override
	public DataResult<List<TestDrive>> findByIsConfirmTrue() {
		return new SuccessDataResult<List<TestDrive>>(testDriveDao.findByIsConfirmTrue(), Messages.listed);
	}

	@Override
	public DataResult<List<TestDrive>> findByIsConfirmFalse() {
		return new SuccessDataResult<List<TestDrive>>(testDriveDao.findByIsConfirmFalse(), Messages.listed);
	}

	@Override
	public DataResult<List<TestDrive>> findBytestDate(LocalDate testDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<TestDrive>> findAllByCustomer_Id(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<TestDrive>> findAllByCar_Id(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
