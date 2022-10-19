package ru.vk;

import org.jetbrains.annotations.NotNull;

public class LibraryFactory {
    public static @NotNull Library getLibrary(@NotNull LibraryTypes type) throws IllegalAccessException {
        return switch (type) {
            case LIBRARY_FROM_DB_H2 -> new LibraryFromH2();
            case LIBRARY_STATIC, LIBRARY_FROM_FILE -> throw new IllegalAccessException("Данный тип не поддерживается");
        };
    }
}
