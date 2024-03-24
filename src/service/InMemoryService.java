package service;

import model.Book;
import model.Rack;
import model.User;
import repository.BookRepository;
import repository.LibraryRepository;
import repository.RackRepository;
import repository.UserRepository;

import java.util.List;

public class InMemoryService {
    public InMemoryService() {
        BookRepository bookRepository=new BookRepository();
        LibraryRepository libraryRepository=new LibraryRepository();
        RackRepository rackRepository=new RackRepository();
        UserRepository userRepository=new UserRepository();
    }
}
