package data;

import java.util.List;

import entities.User;

public interface UserDAO {
	
	public List<User> index();
	public User create(User user);
	public User show(int id);
	public User update(int fid, User user);
	public Boolean destroy(int id);

}
