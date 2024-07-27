package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service_implimentation.loginHandler_implimentation;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   public static long id=-1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			
			String username =request.getParameter("username");
			String  password =request.getParameter("password");
			
			System.out.println("username :"+ username);
			System.out.println("password :"+ password);
			
			loginHandler_implimentation  userdata =new loginHandler_implimentation ();
			if(userdata.authicate(username, password))
			{
				id=userdata.get_id(username, password);
				response.sendRedirect("Welcome.jsp");
			}
			else
			{
				request.setAttribute("message", "Authication feild");
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			
			
		}catch(Exception e)
		{
			
		}
		doGet(request, response);
	}

}
