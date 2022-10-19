package ru.vk;

import entity.Author;
import entity.Book;
import service.AuthorService;

import java.util.HashSet;
import java.util.Set;

public class LibraryFromH2 extends Library {

    @Override
    Set<Book> getBooksByAuthorFirstName(String authorFirstName) {
        return new AuthorService().getByFirsName(authorFirstName).orElseGet(Author::new).getBooks();
    }
}
