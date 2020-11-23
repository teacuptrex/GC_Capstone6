package co.grandcircus.capstoneTaskList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id=0;
	private String description;
	private Date duedate;
	private boolean complete;
	@ManyToOne
	private User user;
	
	public Task() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
}
