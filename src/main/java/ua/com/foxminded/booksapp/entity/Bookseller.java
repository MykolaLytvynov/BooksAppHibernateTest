package ua.com.foxminded.booksapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Bookseller {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Bookstore bookstore;
}
