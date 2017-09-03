package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.UserFlock;

@Transactional
@Repository
public class UserFlockDAOImpl implements UserFlockDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<UserFlock> index() {
		String query = "SELECT * FROM user_flock";
		@SuppressWarnings("unchecked")
		List<UserFlock> userFlock = em.createNativeQuery(query).getResultList();
		return userFlock;
	}

	@Override
	public UserFlock show(int id) {
		return em.find(UserFlock.class, id);
	}

}
