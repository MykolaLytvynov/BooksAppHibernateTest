package ua.com.foxminded.booksapp.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.booksapp.entity.Author;
import ua.com.foxminded.booksapp.entity.Book;

public class BookDao {
    private final SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book read(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Book result = session.get(Book.class, id);
            if (result != null) {
                Hibernate.initialize(result.getAuthor());
            }
            return result;
        }
    }
}
