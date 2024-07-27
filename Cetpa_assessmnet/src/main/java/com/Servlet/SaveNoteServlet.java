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

public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = null;
        Transaction tx = null;
        try {
            String name = request.getParameter("name");
            String employee_code = request.getParameter("employeeCode");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String profile = request.getParameter("profile");
            String password = request.getParameter("Password");

            // Convert employee code to long
            long id = Long.parseLong(employee_code);

            Registation registation = new Registation(id, name, email, address, profile, password);
            loginHandler_implimentation data=new loginHandler_implimentation();
            if (data.check_idexit(id) &&  data.check_emailExit(email))
            {
            	request.setAttribute("message", "Employee ID is already registered.Also Email is already registered");

                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            }
            if(data.check_idexit(id))
            {
            	request.setAttribute("message", "Employe id already Registerd");
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            }

            // Hibernate save
            session = FactoryProvider.getfactory().openSession();
            tx = session.beginTransaction();
            session.save(registation);
            tx.commit();

            request.setAttribute("message", "Registration successful");
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace(); // Log the exception
            request.setAttribute("message", "Registration failed: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
