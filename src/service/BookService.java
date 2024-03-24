package service;

import model.Book;
import model.Rack;
import model.User;
import repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static repository.LibraryRepository.bookUserMap;
import static repository.LibraryRepository.rackBookMap;

public class BookService {

    public static void addBook(String bookId,String bookTitle,String authorsList[],String publishersList[],String copyList[]){
        List<String>authors=new ArrayList<>(List.of(authorsList));
        List<String>publishers=new ArrayList<>(List.of(publishersList));
        boolean inserted=false;
        for(int i=0;i<copyList.length;i++){
            boolean added=false;
            Book book=new Book(bookId,copyList[i],bookTitle,authors,publishers);

            for(Map.Entry<Rack,List<Book>>entry: rackBookMap.entrySet()){
                Rack rack=entry.getKey();
                List<Book>bookList=entry.getValue();
                boolean found=false;
                for(Book b:bookList){
                    if(b.getBookId()==bookId){
                        found=true;
                        break;
                    }
                }
                if(entry.getValue().size()>5 || found){
                    continue;
                }
                else{
                    book.setRackNo(entry.getKey().getRackId());
                    entry.getValue().add(book);
                    added=true;
                    System.out.println("Added Book to rack No : "+book.getRackNo());
                    break;
                }
            }


            if(added==false){
                System.out.print("Unable to find slot for copy id "+copyList[i]);
            }
        }
        return;
    }

    public static void removeBook(String copyId) {
        for(Map.Entry<Rack, List<Book>>entry:rackBookMap.entrySet()){
            List<Book>bookList=entry.getValue();
            for(Book book: bookList){
                if(book.getCopyId().equals(copyId)){
                    bookList.remove(book);
                    System.out.println("Removed copy id");
                    return;
                }
            }
        }
        System.out.println("Book with given copy id not found");
    }


    public static List<Book> searchBookByAuthor(String searchKeyWord) {
        List<Book>bookList=new ArrayList<>();
        for(Map.Entry<Rack, List<Book>> entry:rackBookMap.entrySet()){
            for(Book b:entry.getValue()){
                if(b.getAuthors().contains(searchKeyWord)){
                    bookList.add(b);
                    if(b.getBorrower()==null)
                        System.out.println("Book Copy "+b.getCopyId()+" "+b.getTitle()+" "+b.getAuthors()+" "+b.getPublishers()+" "+entry.getKey().getRackId());
                    else{
                        System.out.println("Book Copy "+b.getCopyId()+" "+b.getTitle()+" "+b.getAuthors()+" "+b.getPublishers()+" "+"-1 "+ b.getBorrower()+" "+b.getDueDate());
                    }
                }
            }
        }
        return bookList;
    }

    public static List<Book> searchBookByBookId(String searchKeyWord) {
        List<Book>bookList=new ArrayList<>();
        for(Map.Entry<Rack, List<Book>> entry:rackBookMap.entrySet()){
            for(Book b:entry.getValue()){
                if(b.getBookId().equals(searchKeyWord)){
                    bookList.add(b);
                    if(b.getBorrower()==null)
                        System.out.println("Book Copy "+b.getCopyId()+" "+b.getTitle()+" "+b.getAuthors()+" "+b.getPublishers()+" "+entry.getKey().getRackId());
                    else{
                        System.out.println("Book Copy "+b.getCopyId()+" "+b.getTitle()+" "+b.getAuthors()+" "+b.getPublishers()+" "+"-1 "+ b.getBorrower()+" "+b.getDueDate());
                    }
                }
            }
        }
        return bookList;
    }

    public static List<Book> searchBookByPublisher(String searchKeyWord) {
        List<Book>bookList=new ArrayList<>();
        for(Map.Entry<Rack, List<Book>> entry:rackBookMap.entrySet()){
            for(Book b:entry.getValue()){
                if(b.getPublishers().contains(searchKeyWord)){
                    bookList.add(b);
                    if(b.getBorrower()==null)
                        System.out.println("Book Copy "+b.getCopyId()+" "+b.getTitle()+" "+b.getAuthors()+" "+b.getPublishers()+" "+entry.getKey().getRackId());
                    else {
                        System.out.println("Book Copy " + b.getCopyId() + " " + b.getTitle() + " " + b.getAuthors() + " " + b.getPublishers() + " " + "-1 " + b.getBorrower() + " " + b.getDueDate());
                    }
                }
            }
        }
        return bookList;
    }

    public static List<Book> search(String searchCriteria, String searchKeyWord) {
        System.out.println(searchCriteria.toString());
        if(searchCriteria.toString().equals("book_id")){
            return searchBookByBookId(searchKeyWord);
        }else if(searchCriteria.toString().equals("author_id")){
            return searchBookByAuthor(searchKeyWord);
        }else if(searchCriteria.toString().equals("publisher")){
            return searchBookByPublisher(searchKeyWord);
        }else{
            System.out.println("Search Criteria is not available");
            return null;
        }
    }
}
