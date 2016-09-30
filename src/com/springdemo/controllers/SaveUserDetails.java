package com.springdemo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.springdemo.dao.UserDetailsDao;
import com.springdemo.models.UserDetails;

/**
 * Servlet implementation class SaveUserDetails
 */
@WebServlet("/SaveUserDetails")
public class SaveUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDetailsDao userDetailsDao;
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	    userDetailsDao = (UserDetailsDao) context.getBean("userDetailsDao");
	  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userDetailsDao.insertData(request.getParameter("userName"), request.getParameter("phoneNumber"));
		List<UserDetails> fetchedUserDetails = userDetailsDao.fetchAllUserDetails();
		request.setAttribute("userDetails", fetchedUserDetails);
		
		//Forward to the view page
		RequestDispatcher view = request.getRequestDispatcher("ListRecords.jsp");
		view.forward(request, response);
	}

}
