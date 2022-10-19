package dao;

import entity.Author;
import entity.Book;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    Set<Book> getBooksByAuthor(Author author);
}
