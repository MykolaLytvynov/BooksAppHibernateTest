package ua.com.foxminded.booksapp.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.booksapp.entity.Bookseller;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BooksellerDao {
    private final SessionFactory sessionFactory;

    public BooksellerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Bookseller read (Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Bookseller result = session.get(Bookseller.class, id);
            if(result != null) {
                Hibernate.initialize(result.getBookstore());
            }
            return result;
        }
    }

    public List<Bookseller> getAll () {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Bookseller.class);
            Root<Bookseller> root = cq.from(Bookseller.class);
            Query query = session.createQuery(cq);

            return query.getResultList();
        }
    }

    public void create (Bookseller bookseller) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(bookseller);
            session.getTransaction().commit();
        }
    }

    public void update (Bookseller bookseller) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(bookseller);
            session.getTransaction().commit();
        }
    }

    public void delete (Bookseller bookseller) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(bookseller);
            session.getTransaction().commit();
        }
    }
}

