package model;
import java.time.LocalDate;
import java.util.*;
public class Book {
    private String bookId;
    private String copyId;
    private String title;
    private List<String>Authors;

    public Integer getRackNo() {
        return rackNo;
    }

    public void setRackNo(Integer rackNo) {
        this.rackNo = rackNo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    private Integer rackNo;
    private LocalDate dueDate;


    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    private String borrower;

    public Book(String bookId, String copyId, String title, List<String> authors, List<String> publishers) {
        this.bookId = bookId;
        this.copyId = copyId;
        this.title = title;
        this.Authors = authors;
        this.publishers = publishers;
    }

    private List<String>publishers;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCopyId() {
        return copyId;
    }

    public void setCopyId(String copyId) {
        this.copyId = copyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return Authors;
    }

    public void setAuthors(List<String> authors) {
        Authors = authors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }
}
