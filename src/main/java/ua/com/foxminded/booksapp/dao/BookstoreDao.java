package ua.com.foxminded.booksapp.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import ua.com.foxminded.booksapp.entity.Bookstore;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class BookstoreDao implements CrudOperations<Bookstore, Integer> {
    private final Session session;

    public Bookstore read(Integer id) {
        return session.get(Bookstore.class, id);
    }

    public List<Bookstore> getAll() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Bookstore.class);
        Root<Bookstore> root = cq.from(Bookstore.class);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public void create(Bookstore bookstore) {
        session.beginTransaction();
        session.save(bookstore);
        session.getTransaction().commit();
    }

    public void update(Bookstore bookstore) {
        session.beginTransaction();
        session.update(bookstore);
        session.getTransaction().commit();
    }

    public void delete(Bookstore bookstore) {
        session.beginTransaction();
        session.delete(bookstore);
        session.getTransaction().commit();
    }

}
