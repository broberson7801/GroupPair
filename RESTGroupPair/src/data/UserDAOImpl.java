package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UtilityDAO dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> index() {
		String query = "SELECT * FROM user";
		List<User> user = em.createNativeQuery(query).getResultList();
		return user;
	}

	@Override
	public User create(User user) {

		em.persist(user);
		em.close();

		return em.find(User.class, user.getId());

	}

	@Override
	public User show(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User update(int fid, User user) {
		User managed = em.find(User.class, fid);
		if (dao.isEmailAddressValid(user.getEmail()) == true) {
			managed.setEmail(user.getEmail());
		} else {
			return null;
		}
		managed.setFirstName(user.getFirstName());
		managed.setLastName(user.getLastName());

		return em.find(User.class, user.getId());

	}

	@Override
	public Boolean destroy(int id) {
		User user = em.find(User.class, id);

		if (user != null) {
			em.remove(user);
			return true;
		} else {
			return false;
		}
	}

}
