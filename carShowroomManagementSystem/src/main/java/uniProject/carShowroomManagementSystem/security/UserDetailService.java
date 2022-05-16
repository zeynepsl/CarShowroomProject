package uniProject.carShowroomManagementSystem.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.User;
import uniProject.carShowroomManagementSystem.dataAccess.UserDao;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{
	
	private final UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
		return new UserDetail(user.getEmail(), user.getPassword(), Set.copyOf(user.getRoles()));
	}
}
