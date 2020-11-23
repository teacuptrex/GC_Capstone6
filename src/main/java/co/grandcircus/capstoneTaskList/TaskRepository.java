package co.grandcircus.capstoneTaskList;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>{
	
	public List<Task> findByUser(User user);

}
