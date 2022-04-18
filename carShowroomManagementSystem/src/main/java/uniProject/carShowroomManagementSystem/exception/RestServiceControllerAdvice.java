package uniProject.carShowroomManagementSystem.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uniProject.carShowroomManagementSystem.core.utility.result.ErrorResult;


//Spring'de bir REST API için istisna işleme mekanizma uygulamasi:
//Springe bu sinif exceptinlari handle etmek için kullanilacak talimatini verebilmek icin: @RestControllerAdvice

@RestControllerAdvice// --> global bir @ExceptionHandler için  destek sağlar .
//birden çok dağınık @ExceptionHandler s'mizi tek bir global hata işleme bileşeninde birleştirmemize olanak tanır .
public class RestServiceControllerAdvice extends ResponseEntityExceptionHandler{
	//global de herhangi bir exception'i handle edebilmek icin bu class i olusturduk
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResult onDataIntegrityViolationException(DataIntegrityViolationException exception){
		return new ErrorResult(exception.getLocalizedMessage());
	}
}
