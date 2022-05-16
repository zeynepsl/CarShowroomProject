package uniProject.carShowroomManagementSystem.business.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.AuthService;
import uniProject.carShowroomManagementSystem.business.CustomerService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.ErrorDataResult;
import uniProject.carShowroomManagementSystem.core.util.result.SuccessDataResult;
import uniProject.carShowroomManagementSystem.dto.auth.LoginDto;
import uniProject.carShowroomManagementSystem.dto.customer.CustomerResponseDto;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService{
	
	private final CustomerService customerService;
	private final AuthenticationManager authenticationManager; 

	@Override
	public DataResult<CustomerResponseDto> login(LoginDto loginDto) {
		try {
			CustomerResponseDto customerToCheck = customerService.findByEmail(loginDto.getEmail()).getData();
			if (customerToCheck == null) {
				return new ErrorDataResult<CustomerResponseDto>(null, Messages.userNotFound);
			}

			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new SuccessDataResult<CustomerResponseDto>(customerToCheck, Messages.successLogin);
		} catch (Exception e) {
			return new ErrorDataResult<CustomerResponseDto>(null, Messages.badCredential);
		}
	}
	
}
