package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Flock;

@Transactional
@Repository
public class FlockDAOImpl implements FlockDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flock> index() {
		String query = "SELECT * FROM flock";
		List<Flock> flock = em.createNativeQuery(query).getResultList();
		return flock;
	}

	@Override
	public Flock create(Flock flock) {
 
		em.persist(flock);
		em.flush();

		return em.find(Flock.class, flock.getId());
	}

	@Override
	public Flock show(int id) {
		return em.find(Flock.class, id);
	}

	@Override
	public Flock update(int fid, Flock flock) {
		Flock managed = em.find(Flock.class, fid);
		managed.setFlockName(flock.getFlockName());
		managed.setSize(flock.getSize());
		managed.setTask(flock.getTask());
		managed.setTaskDescription(flock.getTaskDescription());
		managed.setComplete(flock.isComplete());

		return em.find(Flock.class, fid);
	}

	@Override
	public Boolean destroy(int id) {
		Flock flock = em.find(Flock.class, id);

		if (flock != null) {
			em.remove(flock);
			return true;
		} else {
			return false;
		}
	}

}
