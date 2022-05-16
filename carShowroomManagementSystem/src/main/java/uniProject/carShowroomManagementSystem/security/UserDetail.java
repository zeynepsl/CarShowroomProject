package uniProject.carShowroomManagementSystem.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.core.entity.Role;

@RequiredArgsConstructor
public class UserDetail implements UserDetails{
	
	private final String email;//username gibi unique olarak email kullaniyoruz
    private final String password;
    private final Set<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
        		.stream()
        		.map(role -> new SimpleGrantedAuthority(
        				role.getName())).collect(Collectors.toList()
        						);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
