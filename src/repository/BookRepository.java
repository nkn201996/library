package repository;

import model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    static Map<String, Book> bookMap;

    public BookRepository() {
        bookMap=new HashMap<>();
    }

    public static Map<String, Book> getBookMap() {
        return bookMap;
    }

    public static void setBookMap(Map<String, Book> bookMap) {
        BookRepository.bookMap = bookMap;
    }
}
