package tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Flock;
import entities.FlockMember;
import entities.User;
import entities.UserFlock;

public class EntityTests {

	private EntityManagerFactory emf;
	private EntityManager em;

	private Flock flock;
	private User user;
	private UserFlock userFlock;

	@Before
	public void setUp() {

		emf = Persistence.createEntityManagerFactory("group");
		em = emf.createEntityManager();

		flock = em.find(Flock.class, 1);
		user = em.find(User.class, 1);
		userFlock = em.find(UserFlock.class, 1);

	}

	@After
	public void tearDown() {
		em.close();
		emf.close();

		flock = null;
		user = null;
		userFlock = null;
	}

	// User Entity Tests
	@Test
	public void test_user_for_user_name() {
		assertNotEquals("televison", user.getFirstName());
		assertEquals("Some", user.getFirstName());
	}

	@Test
	public void test_user_for_flock_id() {
		assertNotEquals(17, user.getUserFlockInUser().get(0).getId());
		assertEquals(1, user.getUserFlockInUser().get(0).getId());
	}

	// UserFlock Entity Tests
	@Test
	public void test_user_flock_for_user_email() {
		assertNotEquals("kanagroo", userFlock.getUser().getEmail());
		assertEquals("dude@dude.com", userFlock.getUser().getEmail());
	}

	@Test
	public void test_user_flock_for_group_name() {
		assertNotEquals("Eucalyptus", userFlock.getFlock().getFlockName());
		assertEquals("one man crew", userFlock.getFlock().getFlockName());
	}

	// Flock Entity Tests
	@Test
	public void test_flock_for_user_flock_id() {
		assertNotEquals(76, flock.getUserFLockInFlock().get(0).getId());
		assertEquals(1, flock.getUserFLockInFlock().get(0).getId());
	}

	// Random Traversal across all three tables
	@Test
	public void test_flock_for_user_last_name() {
		assertNotEquals("movie", flock.getUserFLockInFlock().get(0).getUser().getLastName());
		assertEquals("Dude", flock.getUserFLockInFlock().get(0).getUser().getLastName());
	}

}
