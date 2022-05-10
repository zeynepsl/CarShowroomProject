package uniProject.carShowroomManagementSystem.core.util.result;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}

}
