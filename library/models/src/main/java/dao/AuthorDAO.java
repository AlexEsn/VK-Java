package dao;

import entity.Author;

import java.sql.SQLException;
import java.util.Optional;

public interface AuthorDAO {
    Optional<Author> getByFirsName(String firstName);
}
