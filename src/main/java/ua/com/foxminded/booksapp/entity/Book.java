package ua.com.foxminded.booksapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)//фишка тут
    @ToString.Exclude//фишка тут
    private Author author;
}
