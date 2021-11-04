package ua.com.foxminded.booksapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}