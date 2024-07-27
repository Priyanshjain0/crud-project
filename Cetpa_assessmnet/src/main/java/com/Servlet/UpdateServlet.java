package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.service_implimentation.loginHandler_implimentation;

import Entites.Registation;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		long id = Long.parseLong(request.getParameter("emp_id")); // Ensure 'id' is passed or use session to get it

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String profile = request.getParameter("profile");
		System.out.println("update "+ id);
		System.out.println("updat "+ name);
		System.out.println("updat "+ email);
		System.out.println("updat "+ address );
		System.out.println("updat "+ address );

		Session session = null;
		Transaction tx = null;
		session = FactoryProvider.getfactory().openSession();
		tx = session.beginTransaction();

		


			try {

				Registation employee = session.get(Registation.class, id);
				if (employee != null) {
					// Example update, modify as needed
					employee.setEmp_name(name);
					employee.setEmp_email(email);
					employee.setEmp_address(address);
					employee.setEmp_profile(profile);
					//                    

					session.update(employee);
					tx.commit();
					request.setAttribute("message", " Updated sucessfully");

					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				} else {
					System.out.println("Employee with ID " + id + " not found.");
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
		doGet(request, response);
	}







}
