package service;

import model.Book;
import model.Rack;
import model.User;
import repository.LibraryRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static repository.LibraryRepository.rackBookMap;
import static repository.UserRepository.userBookMap;

public class UserService {
    public static void borrowBook(String bookId, String userId, LocalDate date){
        if(userBookMap.containsKey(userId) && userBookMap.get(userId).size()>=5){
            System.out.println("Already issued enough books");
            return;
        }
        if(!userBookMap.containsKey(userId)){
            userBookMap.put(userId, new ArrayList<>());
        }
        for(Map.Entry<Rack,List<Book>>entry:rackBookMap.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.getBookId().equals(bookId) && book.getBorrower() == null) {
                    book.setBorrower(userId);
                    book.setDueDate(date);
                    userBookMap.get(userId).add(book);
                    System.out.println("Issued book from rack no " + book.getRackNo() + " with copy id " + book.getCopyId());
                    return;
                }
            }
        }
    }

    public static void borrowCopy(String copyId,String userId,LocalDate date){
        if(userBookMap.containsKey(userId) && userBookMap.get(userId).size()>=5){
            System.out.println("Already issued enough books");
            return;
        }
        if(!userBookMap.containsKey(userId)){
            userBookMap.put(userId, new ArrayList<>());
        }
        for(Map.Entry<Rack,List<Book>>entry:rackBookMap.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.getCopyId().equals(copyId) && book.getBorrower() == null) {
                    book.setBorrower(userId);
                    book.setDueDate(date);
                    userBookMap.get(userId).add(book);
                    System.out.println("Issued book from rack no " + book.getRackNo() + " with copy id " + book.getCopyId());
                    return;
                }
            }
        }
    }
    public static  void returnCopy(String copyId){
        for(Map.Entry<Rack,List<Book>>entry:rackBookMap.entrySet()){
            boolean found=false;
            for(Book book:entry.getValue()){
                if(book.getCopyId()==copyId){
                    book.setDueDate(null);
                    book.setBorrower(null);
                    found=true;
                    break;
                }
            }
            if(found)
                break;
        }

        for(Map.Entry<String,List<Book>>entry:userBookMap.entrySet()){
            for(Book book:entry.getValue()){
                if(book.getCopyId()==copyId){
                    entry.getValue().remove(book);
                }
            }
        }
        return;
    }

    public static List<Book> getBorrowedBooks(String userId){
        if(!userBookMap.containsKey(userId)){
            System.out.println("No books borrowed for user "+userId);
        }
        for(Book book:userBookMap.get(userId)){
            System.out.println("Book Copy : "+book.getCopyId()+" "+book.getDueDate());
        }
        return userBookMap.get(userId);
    }
}
