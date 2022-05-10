package uniProject.carShowroomManagementSystem.controller;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uniProject.carShowroomManagementSystem.exception.ApiError;

@RestControllerAdvice// --> global bir @ExceptionHandler için  destek sağlar .
//birden çok dağınık @ExceptionHandler'mizi tek bir global hata işleme bileşeninde birleştirmemize olanak tanır .
public class RestServiceControllerAdvice extends ResponseEntityExceptionHandler{
	//global de herhangi bir exception'i handle edebilmek icin bu class i olusturduk
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> onDataIntegrityViolationException(DataIntegrityViolationException ex){
		return ResponseEntity.badRequest().body(new ApiError(ex.getLocalizedMessage()));
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> onRuntimeExceptionHandled(RuntimeException ex) {
		return ResponseEntity.badRequest().body(new ApiError(ex.getLocalizedMessage()));
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> onConstraintViolationException(ConstraintViolationException ex){
		return ResponseEntity.badRequest().body(new ApiError(ex.getLocalizedMessage()));
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> onPropertyValueException(PropertyValueException ex){
		return ResponseEntity.badRequest().body(new ApiError(ex.getLocalizedMessage()));
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> onIllegalArgumentException(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(new ApiError(ex.getLocalizedMessage()));
    }
}
