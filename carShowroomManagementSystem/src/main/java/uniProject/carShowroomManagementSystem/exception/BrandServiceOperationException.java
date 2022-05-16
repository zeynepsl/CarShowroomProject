package uniProject.carShowroomManagementSystem.exception;

public final class BrandServiceOperationException {
	private BrandServiceOperationException() {
	}
	
	public static class BrandAlreadyExistsException extends BaseException{
		public BrandAlreadyExistsException(String message) {
			super(message);
		}
	}
}
