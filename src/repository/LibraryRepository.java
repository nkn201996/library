package repository;

import model.Book;
import model.Library;
import model.Rack;
import model.User;

import java.util.*;

public class LibraryRepository {
    public static Map<Book, User>bookUserMap;
    public static Map<Rack, List<Book>> rackBookMap;

    public LibraryRepository() {
        bookUserMap=new HashMap<>();
        rackBookMap=new HashMap<>();
    }

    public static Map<Book, User> getBookUserMap() {
        return bookUserMap;
    }

    public static void setBookUserMap(Map<Book, User> bookUserMap) {
        LibraryRepository.bookUserMap = bookUserMap;
    }

    public static Map<Rack, List<Book>> getRackBookMap() {
        return rackBookMap;
    }

    public static void setRackBookMap(Rack rack, Book book) {
        rackBookMap.get(rack).add(book);
    }

    public static Map<Book, User> getbookUserMap() {
        return bookUserMap;
    }

    public void setbookUserMap(Book book, User user) {
        bookUserMap.put(book,user) ;
    }

}
