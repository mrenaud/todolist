package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import com.fasterxml.jackson.databind.JsonNode;
import views.html.*;
import views.html.helper.form;
import models.Task;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

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
			  Task.delete(id);
			  return redirect(routes.Application.tasks());
		  }
		  public static Result listTask() {
		        List<Task> tasks = Task.all();
		        return ok(Json.toJson(tasks));
		} 
		  public static Result listTaskFromTo()
		    {
		    	if(request().accepts("application/json"))
		    	{
		    		JsonNode body = request().body().asJson();
		    		System.out.println(body);
		    		int from = body.get("from").asInt();
		        	int to =  body.get("to").asInt();
		        	List<Task> tasks = Task.findNext(from, to);
		        	System.out.println(Json.toJson(tasks));
		        	return ok(Json.toJson(tasks));
		    	}
		    	return badRequest();
		    }
		  
		 
		 
		  
		  
		

   
  

}
