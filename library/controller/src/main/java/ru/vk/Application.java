package ru.vk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import org.jetbrains.annotations.NotNull;
import serialize.BookConverter;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(@NotNull String[] args) {
        try {
            Library library = LibraryFactory.getLibrary(LibraryTypes.LIBRARY_FROM_DB_H2);
            Set<Book> books = library.getBooksByAuthorFirstName(args[0]);
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Book.class, new BookConverter());
            Gson gson = builder.create();
            System.out.println(gson.toJson(books));
        } catch (IllegalAccessException exception) {
            System.out.println(exception.getMessage());
        } catch (IndexOutOfBoundsException exception){
            System.out.println("Требуются данные на вход");
        }
    }
}
