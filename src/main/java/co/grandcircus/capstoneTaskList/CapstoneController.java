package co.grandcircus.capstoneTaskList;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CapstoneController {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private TaskRepository taskrepo;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String login(){
		
		return "login";
		
	}
	
	@PostMapping("/login")
	public String loginVerif(String email, String password, Model model) {
		
		User user = userrepo.findByEmail(email);
		
		if(user==null) {
			return "redirect:/";
		} else{
			if(user.getPassword().compareTo(password)==0) {
				session.setAttribute("user",user);
				model.addAttribute("user",user);
				return "redirect:/tasks/" +user.getId();
			} else  {
				return "redirect:/";
			}
		}
		
	}
	
	@PostMapping("/register")
	public String register(User user) {
		
		if(user==null) {
			return "redirect:/login";
		} else{
			userrepo.save(user);
			return "redirect:/tasks/" + user.getId();
		}
		
	}
	
	@PostMapping("/addtask/{userid}")
	public String addTask(@PathVariable Long userid,Task task) {
		
		task.setUser(userrepo.findById(userid).orElse(null));
		taskrepo.save(task);
		
		return "redirect:/tasks/"+userid;
	}
	
	@PostMapping("/update/{userid}/{id}")
	public String updateCompletion(@PathVariable Long userid, @PathVariable Long id, Model model) {
		List<Task> tasks = taskrepo.findByUser(userrepo.findById(id).get());
		model.addAttribute("tasks",tasks);
		
		for(Task tsk : tasks) {
			if(tsk.getId()==id) {
				Task task = tsk;
				if(task.isComplete()) {
					task.setComplete(false);
				} else {
					task.setComplete(true);
				}
				taskrepo.save(task);
			} else {
				
			}
		}
		
		
		
		model.addAttribute("userid",userid);
		
		return "redirect:/tasks/"+userid;
	}
	
	@GetMapping("/tasks/{id}")
	public String userTasks(@PathVariable Long id, Model model) {
		
		List<Task> tasks = taskrepo.findByUser(userrepo.findById(id).get());
		model.addAttribute("tasks",tasks);
		model.addAttribute("userid",id);
		
		return "tasks";
		
	}
	
	@PostMapping("/delete/{userid}/{id}")
	public String deleteTask(@PathVariable Long userid, @PathVariable Long id,Model model) {
		List<Task> tasks = taskrepo.findByUser(userrepo.findById(id).get());
		model.addAttribute("tasks",tasks);
		
		for(Task tsk : tasks) {
			if(tsk.getId()==id) {
				taskrepo.deleteById(id);
			} else {
				
			}
		}
		
		
		
		model.addAttribute("userid",userid);
		return "redirect:/tasks/"+userid;
	}
	
}
