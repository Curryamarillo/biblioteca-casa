package com.biblioteca.book;

import com.biblioteca.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String editorial;
    @Column(nullable = false, unique = true)
    private String isbn;
    private String imagePath;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User lentTo;
}