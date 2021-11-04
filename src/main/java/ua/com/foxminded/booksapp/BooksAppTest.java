package ua.com.foxminded.booksapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.foxminded.booksapp.dao.AuthorDao;
import ua.com.foxminded.booksapp.dao.BookDao;
import ua.com.foxminded.booksapp.dao.BooksellerDao;

public class BooksAppTest {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

//            Testing without annotation
//            BookstoreDao bookstoreDao = new BookstoreDao(sessionFactory);
//            System.out.println(bookstoreDao.getAll());

//            Testing @OneToOne
//            BooksellerDao booksellerDao = new BooksellerDao(sessionFactory);
//            System.out.println(booksellerDao.read(1));
//            System.out.println(booksellerDao.getAll());

//            Testing @ManyToOne
            BookDao bookDao = new BookDao(sessionFactory);
            System.out.println(bookDao.read(1));

//            Testing @OneToMany
            AuthorDao authorDao = new AuthorDao(sessionFactory);
            System.out.println(authorDao.read(1));


        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
