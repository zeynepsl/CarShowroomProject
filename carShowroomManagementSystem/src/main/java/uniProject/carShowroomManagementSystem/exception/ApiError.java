package uniProject.carShowroomManagementSystem.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStap;
	
	private String message;
	
	private ApiError() {
		timeStap = LocalDateTime.now();
	}
	
	public ApiError(String message) {
		this();
		this.message = message;
	}
}
