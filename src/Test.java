import org.hibernate.Session;

import pojo.Login;

public class Test {

	public static void main(String args[]){
		Login abc = new Login(1,"sssasas","llllll");
		
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		session.save(abc);
		session.getTransaction().commit();
		session.close();
	}
	
}
