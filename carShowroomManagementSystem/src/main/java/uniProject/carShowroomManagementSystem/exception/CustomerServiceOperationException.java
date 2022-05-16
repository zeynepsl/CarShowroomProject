package uniProject.carShowroomManagementSystem.exception;

public class CustomerServiceOperationException {
	private CustomerServiceOperationException() {
	}
	
	public static class CustomerNotFoundException extends BaseException{
		public CustomerNotFoundException(String message) {
			super(message);
		}
	}
	
	public static class CustomerAlreadyExistsException extends BaseException {
		public CustomerAlreadyExistsException(String message) {
			super(message);
		}
	}
}
