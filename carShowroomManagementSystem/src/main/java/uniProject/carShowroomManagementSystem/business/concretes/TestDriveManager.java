package uniProject.carShowroomManagementSystem.business.concretes;

import java.time.LocalTime;
import java.util.List;

import uniProject.carShowroomManagementSystem.business.abstracts.TestDriveService;
import uniProject.carShowroomManagementSystem.core.utilities.results.DataResult;
import uniProject.carShowroomManagementSystem.core.utilities.results.Result;
import uniProject.carShowroomManagementSystem.entities.concretes.TestDrive;

public class TestDriveManager implements TestDriveService{

	@Override
	public Result add(TestDrive entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(TestDrive entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TestDrive> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<TestDrive>> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	public DataResult<List<TestDrive>> findBytestDate(LocalTime testDate) {
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
