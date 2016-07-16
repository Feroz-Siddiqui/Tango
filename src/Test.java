import java.util.Date;

import org.hibernate.Session;

import pojo.Login;
import pojo.Address;

public class Test {

	public static void main(String args[]){
		
		Address add = new Address("Malleswaram ","bangalore","Karnataka","560055");
		Login abc = new Login("feroz","siddiqui","student",new Date(),1,add);
		
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		session.save(abc);
		session.getTransaction().commit();
		session.close();
	}
	
}
