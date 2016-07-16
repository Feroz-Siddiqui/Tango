package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import constant.LoginConstant;
import hibernate.HibernateSessionFactory;
import pojo.Address;
import pojo.Login;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		printParam(request);
		String first_name = request.getParameter(LoginConstant.FIRST_NAME);
		String last_name = request.getParameter(LoginConstant.LAST_NAME);
		String user_type = request.getParameter(LoginConstant.USER_TYPE);
		String street = request.getParameter(LoginConstant.STREET);
		String city = request.getParameter(LoginConstant.CITY);
		String state = request.getParameter(LoginConstant.STATE);
		String zipcode = request.getParameter(LoginConstant.ZIPCODE);
	
		Address add = new Address(street,city,state,zipcode);
		Login abc = new Login(first_name,last_name,user_type,new Date(),1,add);
		
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		session.save(abc);
		session.getTransaction().commit();
		session.close();
		
		request.getRequestDispatcher("/dashboard/dashboard.jsp").forward(request, response);
		
	
	}

	private void printParam(HttpServletRequest request) {
		// TODO Auto-generated method stub
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.print("param name --> "+paramName+" ");
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                System.out.println("paramValue--> "+paramValue);

            	
            }
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
