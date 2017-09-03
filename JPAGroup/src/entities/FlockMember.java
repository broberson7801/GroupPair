package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flock_members")
public class FlockMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToMany(mappedBy = "flockMembers", cascade = CascadeType.ALL)
	private UserFlock userFlockInFlockMembers;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserFlock getUserFlockInFlockMembers() {
		return userFlockInFlockMembers;
	}

	public void setUserFlockInFlockMembers(UserFlock userFlockInFlockMembers) {
		this.userFlockInFlockMembers = userFlockInFlockMembers;
	}

	public int getId() {
		return id;
	}

}
