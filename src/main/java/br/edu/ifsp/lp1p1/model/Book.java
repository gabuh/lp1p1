package br.edu.ifsp.lp1p1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String publicationYear;
    private Integer numberOfCopies;
    private Integer numberOfCopiesAvailable;

}
