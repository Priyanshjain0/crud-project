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

import Entites.Registation;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		long id = loginServlet.id; 
		Session session = null;
		Transaction tx = null;
        try {
        	session = FactoryProvider.getfactory().openSession();
            tx = session.beginTransaction();
            Registation employee = session.get(Registation.class, id);
            
            	session.delete(employee);
                tx.commit();
                request.setAttribute("message", "Data delete successful");
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
                
               
            
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


