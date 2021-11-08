package ua.com.foxminded.booksapp.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import ua.com.foxminded.booksapp.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class BookDao implements CrudOperations<Book, Integer> {
    private final Session session;

    public Book read(Integer id) {
        return session.get(Book.class, id);
    }

    public List<Book> getAll() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void create(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
    }

    public void update(Book book) {
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
    }

    public void delete(Book book) {
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
    }
}
