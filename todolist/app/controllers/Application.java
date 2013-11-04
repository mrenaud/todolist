package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;
import views.html.helper.form;
import models.Task;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application extends Controller {
	static Form<Task> taskForm = Form.form(Task.class);
	
		  
//		  public static Result index() {
		 //   return ok(index.render("Test du 4 novembre, merci Antoine."));
		//  }
	 public static Result index() {
		  return redirect(routes.Application.tasks());
		}	
		  
		  public static Result tasks() {
			  return ok(
					    views.html.index.render(Task.all(), taskForm)
					  );
		  }
		  public static Result newTask() {
			  Form<Task> filledForm = taskForm.bindFromRequest();
			  if(filledForm.hasErrors()) {
			    return badRequest(
			      views.html.index.render(Task.all(), filledForm)
			    );
			  } else {
			    Task.create(filledForm.get());
			    return redirect(routes.Application.tasks());  
			  }
		  }
		  
		  public static Result deleteTask(Long id) {
		    return TODO;
		  }
		  
		 
		 
		

   
  

}
