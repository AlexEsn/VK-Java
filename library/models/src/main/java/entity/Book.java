package entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Book")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer totalPages;
    private String isbn;
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Author> authors;
}
