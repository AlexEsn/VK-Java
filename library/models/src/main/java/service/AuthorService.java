package service;

import bl.HibernateUtil;
import bl.SessionUtil;
import dao.AuthorDAO;
import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorService extends SessionUtil implements AuthorDAO {

    @Override
    public Optional<Author> getByFirsName(String firstName) {
        try {
            openTransactionSession();

            String sql = "SELECT * FROM Author WHERE FIRST_NAME = :firstName";

            Session session = getSession();
            Query query = session.createNativeQuery(sql).addEntity(Author.class);
            query.setParameter("firstName", firstName);

            Author Author = (Author) query.getSingleResult();

            closeTransactionSesstion();

            return Optional.ofNullable(Author);

        } catch (Exception sqlException) {
            return Optional.empty();
        }

    }
}