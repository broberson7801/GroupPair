package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.FlockMember;

@Transactional
@Repository
public class FlockMemberDAOImpl implements FlockMemberDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<FlockMember> index() {
		List<FlockMember> flockMembers = em.createNativeQuery("SELECT * FROM flock_members").getResultList();
		return flockMembers;
	}

	@Override
	public FlockMember create(FlockMember flockMember) {
		em.persist(flockMember);
		em.flush();

		return em.find(FlockMember.class, flockMember.getId());
	}

	@Override
	public FlockMember show(int id) {
		return em.find(FlockMember.class, id);
	}

	@Override
	public FlockMember update(int fid, FlockMember flockMember) {
		FlockMember managed = em.find(FlockMember.class, fid);
		managed.setFirstName(flockMember.getFirstName());
		managed.setLastName(flockMember.getLastName());

		return em.find(FlockMember.class, flockMember.getId());
	}

	@Override
	public Boolean destroy(int id) {
		FlockMember flockMember = em.find(FlockMember.class, 1);

		if (flockMember != null) {
			em.remove(flockMember);
			return true;
		} else {
			return false;
		}
	}

}
