package serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import entity.Book;

import java.lang.reflect.Type;

public class BookConverter implements JsonSerializer<Book> {

    @Override
    public JsonElement serialize(Book src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("title", src.getTitle());
        object.addProperty("totalPages", src.getTotalPages());
        object.addProperty("isbn", src.getIsbn());
//        object.("authors", src.getAuthors());
        return object;
    }
}
