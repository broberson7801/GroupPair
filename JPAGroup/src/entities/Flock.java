package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Flock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "flock_name")
	private String flockName;

	private String task;

	private boolean complete;

	@Column(name = "task_description")
	private String taskDescription;

	private int size;

	@OneToMany(mappedBy = "flock")
	private List<UserFlock> userFLockInFlock;

	public String getFlockName() {
		return flockName;
	}

	public void setFlockName(String flockName) {
		this.flockName = flockName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<UserFlock> getUserFLockInFlock() {
		return userFLockInFlock;
	}

	public void setUserFLockInFlock(List<UserFlock> userFLockInFlock) {
		this.userFLockInFlock = userFLockInFlock;
	}

	public int getId() {
		return id;
	}

}