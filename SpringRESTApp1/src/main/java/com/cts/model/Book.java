package com.cts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String name;
    private float cost;
    private LocalDate publishDate;

    @OneToOne
    @JoinColumn(name="book_authid")
    private Author author;
}
