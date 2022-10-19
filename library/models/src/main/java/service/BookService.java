package service;

import bl.SessionUtil;
import dao.AuthorDAO;
import dao.BookDAO;
import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class BookService extends SessionUtil implements BookDAO {

    @Override
    public Set<Book> getBooksByAuthor(Author author) {
        try {
            openTransactionSession();

            String sql = "SELECT * FROM BOOK JOIN AUTHOR_BOOK AB on BOOK.ID = AB.BOOKS_ID JOIN AUTHOR A on A.ID = AB.AUTHORS_ID WHERE FIRST_NAME = :firstName";

            Session session = getSession();
            Query query = session.createNativeQuery(sql).addEntity(Book.class);
            query.setParameter("firstName", author.getFirstName());

            Set<Book> books = (Set<Book>) query.getSingleResult();

            closeTransactionSesstion();

            return books;

        } catch (Exception sqlException) {
            return new HashSet<>();
        }

    }
}