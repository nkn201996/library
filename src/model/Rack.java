package model;
import java.util.*;
public class Rack {
    private Integer rackId;
    private List<Book> bookList;
    Integer rackCapacity;

    public Rack(Integer rackId, Integer rackCapacity) {
        this.rackId = rackId;
        this.rackCapacity=rackCapacity;
    }

    public Integer getRackId() {
        return rackId;
    }

    public void setRackId(Integer rackId) {
        this.rackId = rackId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Integer getRackCapacity() {
        return rackCapacity;
    }

    public void setRackCapacity(Integer rackCapacity) {
        this.rackCapacity = rackCapacity;
    }
}
