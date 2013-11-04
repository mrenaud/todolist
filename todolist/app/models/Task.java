package models;

import java.util.*;

import play.data.validation.Constraints.Required;
import play.mvc.Result;
import play.db.ebean.*;
import javax.persistence.*;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Task extends Model{
	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);
  @Id
  public Long id;
  @Required
  public String label;
  
  public static List<Task> all() {
	  return find.all();
    
  }
  
  public static void create(Task task) {
 
	  task.save();
	  }
  
  public static void delete(Long id) {
	  find.ref(id).delete();
  }
  

	

	
    
}