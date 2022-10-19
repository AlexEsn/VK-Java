package ru.vk;

import entity.Book;

import java.util.Set;

public abstract class Library {
    abstract Set<Book> getBooksByAuthorFirstName(String authorFirstName);
}
