package uniProject.carShowroomManagementSystem.core.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class EmailCheckManager implements EmailCheckService{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	/*	public static boolean validate(String email) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		        return matcher.find();
		}*/

	@Override
	public boolean emailCheck(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if(matcher.find()) {
			return true;
		}
		return false;
	}

}
