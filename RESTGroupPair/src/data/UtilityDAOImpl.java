package data;

import org.apache.commons.validator.routines.EmailValidator;

public class UtilityDAOImpl implements UtilityDAO{

	@Override
	public boolean checkForSQLInjection(String input) {
		if(input.contains("=") || input.contains(";") || input.contains(">") || input.contains("<") ||
				input.contains(">=") || input.contains("<=") || input.contains("%") || input.contains("/*")
				|| input.contains("*/") || input.contains("--")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmailAddressValid(String email) {
		boolean valid = EmailValidator.getInstance().isValid(email);
		return valid;
	}
}
