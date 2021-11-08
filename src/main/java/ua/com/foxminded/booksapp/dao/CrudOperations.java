package ua.com.foxminded.booksapp.dao;

import java.util.List;

public interface CrudOperations <T, ID> {

    void create (T entity);
    T read (ID id);
    List<T> getAll();
    void update (T entity);
    void delete (T entity);
}
