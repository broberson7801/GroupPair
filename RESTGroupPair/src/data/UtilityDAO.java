package data;

public interface UtilityDAO {
	
	public boolean checkForSQLInjection(String input);
	public boolean isEmailAddressValid(String email);

}
