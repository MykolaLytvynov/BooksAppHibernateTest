package ua.com.foxminded.booksapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
}
