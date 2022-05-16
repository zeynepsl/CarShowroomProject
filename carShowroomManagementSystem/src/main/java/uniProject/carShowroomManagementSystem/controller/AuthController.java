package uniProject.carShowroomManagementSystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.AuthService;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.dto.auth.LoginDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	
	@PostMapping("/login")
	public DataResult<CustomerResponseDto> login(@RequestBody LoginDto loginDto){
		return authService.login(loginDto);
	}
}
