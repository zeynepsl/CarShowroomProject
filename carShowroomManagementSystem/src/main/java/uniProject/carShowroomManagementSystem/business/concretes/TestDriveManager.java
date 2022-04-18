package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniProject.carShowroomManagementSystem.business.abstracts.TestDriveService;
import uniProject.carShowroomManagementSystem.business.constants.Messages;
import uniProject.carShowroomManagementSystem.core.utility.result.DataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;
import uniProject.carShowroomManagementSystem.core.utility.result.Result;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.core.utility.result.SuccessResult;
import uniProject.carShowroomManagementSystem.dataAccess.abstracts.TestDriveDao;
import uniProject.carShowroomManagementSystem.entity.concrete.TestDrive;
import uniProject.carShowroomManagementSystem.entity.dto.TestDriveDto;

@Service
public class TestDriveManager implements TestDriveService{
	
	private TestDriveDao testDriveDao;
	
	@Autowired
	public TestDriveManager(TestDriveDao testDriveDao) {
		this.testDriveDao = testDriveDao;
	}

	@Override
	public Result add(TestDriveDto entity) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<TestDrive>> findByIsConfirmFalse() {
		// TODO Auto-generated method stub
		return null;
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
