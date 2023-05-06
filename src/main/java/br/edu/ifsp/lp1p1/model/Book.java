package br.edu.ifsp.lp1p1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
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

    @Transient
    @JsonIgnore
    @OneToMany
    private final List<Loan> loans = new ArrayList<>();

}
