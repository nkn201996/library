package model;
import java.util.*;
public class Rack {
    private String rackId;
    private List<Book> bookList;

    public String getRackId() {
        return rackId;
    }

    public void setRackId(String rackId) {
        this.rackId = rackId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Rack(String rackId, List<Book> bookList) {
        this.rackId = rackId;
        this.bookList = bookList;
    }
}
