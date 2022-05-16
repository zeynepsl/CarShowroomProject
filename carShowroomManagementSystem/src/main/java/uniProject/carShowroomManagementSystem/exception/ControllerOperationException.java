package uniProject.carShowroomManagementSystem.exception;

public final class ControllerOperationException {

	private ControllerOperationException() {
    }

    public static class CustomerNotValidException extends BaseException {
        public CustomerNotValidException(String message) {
            super(message);
        }
    }

    public static class IDNotValidException extends BaseException {
        public IDNotValidException(String message) {
            super(message);
        }
    }
    
    public static class BrandNotValidException extends BaseException {
        public BrandNotValidException(String message) {
            super(message);
        }
    }
    
    public static class ColorNotValidException extends BaseException{
    	public ColorNotValidException(String message) {
    		super(message);
		}
    }
    
}
