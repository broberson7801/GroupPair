package data;

import java.util.List;

import entities.Flock;

public interface FlockDAO {
	
	public List<Flock> index();
	public Flock create(Flock flock);
	public Flock show(int id);
	public Flock update(int fid, Flock flock);
	public Boolean destroy(int id);

}
