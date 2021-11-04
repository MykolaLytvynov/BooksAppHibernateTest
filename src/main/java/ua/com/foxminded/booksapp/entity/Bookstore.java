package ua.com.foxminded.booksapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Bookstore {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
}
