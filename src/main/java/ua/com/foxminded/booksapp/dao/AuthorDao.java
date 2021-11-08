package ua.com.foxminded.booksapp.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import ua.com.foxminded.booksapp.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class AuthorDao implements CrudOperations <Author, Integer>{
    private final Session session;

    @Override
    public void create(Author author) {
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public Author read(Integer id) {
        return session.get(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void update(Author author) {
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Author author) {
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
    }
}
