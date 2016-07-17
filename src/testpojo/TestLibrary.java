package testpojo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateSessionFactory;

public class TestLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long id = createLibrary();
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Library library = (Library) session.load(Library.class, id);
		System.out.println("library size bok "+library.getBooks().size());
		library.getBooks().remove(0);
		System.out.println("library size boik "+library.getBooks().size());
		tx.commit();
		session.close();
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		Library l2 = (Library) session.load(Library.class, id);
		System.out.println("library size book "+library.getBooks().size());
		Query query = session.createQuery("from Book b");
		List books = query.list();
		System.out.println("book size "+books.size());
		tx.commit();
		session.close();
	}

	static private Long createLibrary() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Library library = new Library();
		library.setName("orphanLib");
		session.save(library);
		Book book = new Book();
		book.setLibrary(library);
		book.setTitle("book 1");
		session.save(book);
		library.getBooks().add(book);
		book = new Book();
		book.setLibrary(library);
		book.setTitle("book 2");
		session.save(book);
		library.getBooks().add(book);
		book = new Book();
		book.setLibrary(library);
		book.setTitle("book 3");
		session.save(book);
		library.getBooks().add(book);
		tx.commit();
		session.close();
		return library.getId();
	}
}
