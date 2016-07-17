package testpojo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateSessionFactory;

public class TestEmail {
	static Long emailId;
	static Long messageId;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Session session = HibernateSessionFactory.getSession();
		  session.getTransaction().begin(); 
		  Email email = new Email("Inverse email"); 
		  Message msg = new Message("Inverse Message");
		  email.setMessage(msg); 
		  msg.setEmail(email); 
		  session.save(email);
		 // session.save(msg); 
		 
		  session.getTransaction().commit(); session.close();
		  
		 /** session = HibernateSessionFactory.getSession();
		 * session.getTransaction().begin(); email = (Email)
		 * session.get(Email.class, emailId); System.out.println(email); msg =
		 * (Message) session.get(Message.class, messageId);
		 * System.out.println(msg); session.getTransaction().commit();
		 * session.getClass();
		 */
	/*	Long id = null;
		SimpleObject obj = new SimpleObject();
		obj.setKey("sl");
		obj.setValue(10L);
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		session.save(obj);
		id = obj.getId();
		session.getTransaction().commit();
		session.close();
		session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		SimpleObject o2 = (SimpleObject) session.load(SimpleObject.class, id);
		SimpleObject o3 = (SimpleObject) session.load(SimpleObject.class, id);
		System.out.println("== "+(o2==o3));
		System.out.println("equal "+o2.equals(o3));
		System.out.println("obj == "+(o2==obj));
		System.out.println("obj equal "+o2.equals(obj));
		session.getTransaction().commit();
		session.close();*/
		
/*		SimpleObject so = new SimpleObject();
		so.setKey("sl");
		so.setValue(10L);
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		session.save(so);
		Long id = so.getId();
		session.getTransaction().commit();
		session.close();
		
		validateSimpleObject(id, 1L);
		so.setValue(2L);
		session = HibernateSessionFactory.getSession();
	
		session.getTransaction().begin();
		session.merge(so);
		session.getTransaction().commit();
		session.close();
		validateSimpleObject(id, 2L);

		*/
	}

	static private SimpleObject validateSimpleObject(Long id, Long value) {
		Session session;
		Transaction tx;// validate the database values
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		SimpleObject so = (SimpleObject) session.load(SimpleObject.class, id);
		System.out.println("so "+so.getKey() +"  "+so.getValue());
		tx.commit();
		session.close();
		return so;
		}
	
}
