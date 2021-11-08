package ua.com.foxminded.booksapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.foxminded.booksapp.dao.AuthorDao;
import ua.com.foxminded.booksapp.dao.BookDao;
import ua.com.foxminded.booksapp.dao.BooksellerDao;
import ua.com.foxminded.booksapp.dao.BookstoreDao;

public class BooksAppTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

//            Testing without annotation
            BookstoreDao bookstoreDao = new BookstoreDao(session);
            System.out.println(bookstoreDao.getAll());

//            Testing @OneToOne
            BooksellerDao booksellerDao = new BooksellerDao(session);
            System.out.println(booksellerDao.read(1));
            System.out.println(booksellerDao.getAll());

//            Testing @ManyToOne
            BookDao bookDao = new BookDao(session);
            System.out.println(bookDao.read(1).getAuthor());
            System.out.println(bookDao.getAll());

//            Testing @OneToMany
            AuthorDao authorDao = new AuthorDao(session);
            System.out.println(authorDao.read(1));
            System.out.println(authorDao.getAll());

        }
    }
}
