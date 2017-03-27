package com.niit.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.loginapp.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String userID=request.getParameter("userID"); //name of the user id field in login.html
	String password =request.getParameter("password"); //name of the password field in login.html
	
	//the container send it to corresponding dao
	
	LoginDao loginDao = new LoginDao();
	//get the request dispatcher so that we dispatch either to home page or login page
	
	
	if(loginDao.isValidCredentials(userID, password))
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.html");
		dispatcher.forward(request, response);
		//navigate/dispatch to home page
	}
	
	else
	{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.html");
		
		PrintWriter writer = response.getWriter();
		writer.append("Invalid crendentilas. please try again....");
		//we have include login.html+this message

		dispatcher.include(request, response);
		
		//navigate/dispatch to login page
		//show error message
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
