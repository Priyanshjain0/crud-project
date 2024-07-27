package com.service_implimentation;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.helper.FactoryProvider;
import com.service.LoginHandler;

import Entites.Registation;

public class loginHandler_implimentation   implements LoginHandler {
	
	Session s=FactoryProvider.getfactory().openSession();

	@Override
	public boolean check_idexit(long id) {
        try {
            String hql = "SELECT COUNT(*) FROM Registation WHERE Emp_id = :id";
            Query query = s.createQuery(hql);
            query.setParameter("id", id);
            long count = (long) query.uniqueResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean check_emailExit(String email) {
        try {
            String hql = "SELECT COUNT(*) FROM Registation WHERE Emp_email = :email";
            Query query = s.createQuery(hql);
            query.setParameter("email", email);
            long count = (long) query.uniqueResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean check_Employe_password(long id, String password) {
		 try {
	            String hql = "SELECT COUNT(*) FROM Registation WHERE Emp_id = :id AND Emp_password = :password";
	            Query query = s.createQuery(hql);
	            query.setParameter("id", id);
	            query.setParameter("password", password);
	            long count = (long) query.uniqueResult();
	            return count > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public String Name_conneted_with_id(long id) {
		try {
            String hql = "SELECT Emp_name FROM Registation WHERE Emp_id = :id";
            Query query = s.createQuery(hql);
            query.setParameter("id", id);
            String name = (String) query.uniqueResult();
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Registation getEmployeeById(long id) {
		 try {
	            return s.get(Registation.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public boolean authicate(String username, String password) {
		 try {
	            String hql = "SELECT COUNT(*) FROM Registation WHERE Emp_email = :email AND Emp_password = :password";
	            Query query = s.createQuery(hql);
	            query.setParameter("email", username);
	            query.setParameter("password", password);
	            long count = (long) query.uniqueResult();
	            return count > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public long get_id(String username, String password) {
		 try {
	            String hql = "SELECT Emp_id FROM Registation WHERE Emp_email = :email AND Emp_password = :password";
	            Query query = s.createQuery(hql);
	            query.setParameter("email", username);
	            query.setParameter("password", password);
	            Long id = (Long) query.uniqueResult();
	            return id != null ? id : 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	}

	

	
	 

}
