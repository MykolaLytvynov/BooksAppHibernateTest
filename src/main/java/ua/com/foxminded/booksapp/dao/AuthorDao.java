package ua.com.foxminded.booksapp.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.booksapp.entity.Author;

public class AuthorDao {
    private final SessionFactory sessionFactory;

    public AuthorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Author read (Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Author result = session.get(Author.class, id);
            return result;
        }
    }
}
