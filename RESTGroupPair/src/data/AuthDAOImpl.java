package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Transactional
@Repository
public class AuthDAOImpl implements AuthDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UtilityDAO dao;

	@Override
	public User register(User user) {
		if (dao.isEmailAddressValid(user.getPassword()) == true) {
			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			user.setEmail(user.getEmail());
			user.setUserName(user.getUserName());
			user.setPassword(encoder.encode(user.getPassword()));
			em.persist(user);
			em.flush();
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User login(User user) {
		String query = "SELECT u FROM User u WHERE u.email = :email";

		User managedUser = em.createQuery(query, User.class).setParameter("email", user.getEmail()).getResultList()
				.get(0);
		if (encoder.matches(user.getPassword(), managedUser.getPassword())) {
			return managedUser;
		}

		return null;
	}

}
