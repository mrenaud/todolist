package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	
		  
//		  public static Result index() {
		 //   return ok(index.render("Test du 4 novembre, merci Antoine."));
		//  }
		  
		  public static Result tasks() {
		    return TODO;
		  }
		  
		  public static Result newTask() {
		    return TODO;
		  }
		  
		  public static Result deleteTask(Long id) {
		    return TODO;
		  }
		  public static Result index() {
			  return redirect(routes.Application.tasks());
			}	  
		

   
  

}
