package com.springdemo.jpamanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Create the Entity Manager Factory Object for JPA.
 * @author jeffin
 */
public class JpaManager {

	private static final EntityManagerFactory emfactory;
	
	static 
	  {    //create EntityManagerFactory object only once    
	    try
	    {          
	    	emfactory = Persistence.createEntityManagerFactory( "Hibernate_JPA" );
	    } 
	    catch (Throwable ex) 
	    {
	    	System.err.println("Application terminated. Could not connect to database.");
	    	//System.exit(0);
	    	throw new ExceptionInInitializerError(ex);
	    }
	  }
	  public static EntityManagerFactory getEntityManagerFactory() {
	     return emfactory;
	  }
}
