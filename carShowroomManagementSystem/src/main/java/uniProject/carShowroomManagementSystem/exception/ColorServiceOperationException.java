package uniProject.carShowroomManagementSystem.exception;

public final class ColorServiceOperationException {
	private ColorServiceOperationException() {
	}
	
	public static class ColorAlreadyExistsException extends BaseException {
		public ColorAlreadyExistsException(String message) {
			super(message);
		}
	}
}
