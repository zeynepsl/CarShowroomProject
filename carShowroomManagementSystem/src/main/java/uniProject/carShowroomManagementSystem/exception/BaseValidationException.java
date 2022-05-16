package uniProject.carShowroomManagementSystem.exception;

public final class BaseValidationException{

	private BaseValidationException() {
	}
	
	public static class BrandNotValidException extends BaseException{
		public BrandNotValidException(String message) {
			super(message);
		}
	}
	
	public static class BrandAlreadyExistsException extends BaseException{
		public BrandAlreadyExistsException(String message) {
			super(message);
		}
	}
	
	public static class ColorAlreadyExistsException extends BaseException {
		public ColorAlreadyExistsException(String message) {
			super(message);
		}
	}
	
}
