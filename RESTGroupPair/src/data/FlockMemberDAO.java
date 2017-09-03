package data;

import java.util.List;

import entities.FlockMember;

public interface FlockMemberDAO {
	
	public List<FlockMember> index();
	public FlockMember create(FlockMember flockMember);
	public FlockMember show(int id);
	public FlockMember update(int fid, FlockMember flockMember);
	public Boolean destroy(int id);


}
