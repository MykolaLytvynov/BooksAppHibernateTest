package ua.com.foxminded.booksapp.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import ua.com.foxminded.booksapp.entity.Bookseller;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class BooksellerDao implements CrudOperations<Bookseller, Integer> {
    private final Session session;

    public Bookseller read(Integer id) {
        Bookseller result = session.get(Bookseller.class, id);
        if (result != null) {
            Hibernate.initialize(result.getBookstore());
        }
        return result;
    }

    public List<Bookseller> getAll() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Bookseller.class);
        Root<Bookseller> root = cq.from(Bookseller.class);
        Query query = session.createQuery(cq);

        return query.getResultList();
    }

    public void create(Bookseller bookseller) {
        session.beginTransaction();
        session.save(bookseller);
        session.getTransaction().commit();
    }

    public void update(Bookseller bookseller) {
        session.beginTransaction();
        session.update(bookseller);
        session.getTransaction().commit();
    }

    public void delete(Bookseller bookseller) {
        session.beginTransaction();
        session.delete(bookseller);
        session.getTransaction().commit();
    }
}

