package data;

import java.util.List;

import entities.UserFlock;

public interface UserFlockDAO {
	public List<UserFlock> index();
	public UserFlock show(int id);


}
