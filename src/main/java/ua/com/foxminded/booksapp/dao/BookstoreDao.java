package ua.com.foxminded.booksapp.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.booksapp.entity.Bookstore;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookstoreDao {
    private final SessionFactory sessionFactory;

    public BookstoreDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Bookstore read (Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Bookstore result = session.get(Bookstore.class, id);
            return result;
        }
    }

    public List<Bookstore> getAll () {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Bookstore.class);
            Root<Bookstore> root = cq.from(Bookstore.class);
            Query query = session.createQuery(cq);

            return query.getResultList();
        }
    }

    public void create (Bookstore bookstore) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(bookstore);
            session.getTransaction().commit();
        }
    }

    public void update (Bookstore bookstore) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(bookstore);
            session.getTransaction().commit();
        }
    }

    public void delete (Bookstore bookstore) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(bookstore);
            session.getTransaction().commit();
        }
    }

}
