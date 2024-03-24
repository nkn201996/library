import service.BookService;
import service.InMemoryService;
import service.LibraryService;
import service.UserService;

import java.time.LocalDate;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        InMemoryService inMemoryService=new InMemoryService();
        LibraryService libraryService=new LibraryService();
        while(true){
            String inputs[]=sc.nextLine().split(" ");
            try{
                switch (inputs[0]) {
                    case "create_library": {
                        libraryService.createLibrarySystem("NK",Integer.parseInt(inputs[1]));
                        break;
                    }
                    case "add_book":{
                        BookService.addBook(inputs[1],inputs[2],inputs[3].split(","),inputs[4].split(","), inputs[5].split(","));
                        break;
                    }
                    case "remove_book_copy":{
                        BookService.removeBook(inputs[1]);
                        break;
                    }
                    case "search":{
                        BookService.search(inputs[1],inputs[2]);
                        break;
                    }
                    case "borrow_book": {
                        UserService.borrowBook(inputs[1], inputs[2], LocalDate.parse(inputs[3]));
                        break;
                    }
                    case "borrow_book_copy": {
                        UserService.borrowCopy(inputs[1], inputs[2], LocalDate.parse(inputs[3]));
                        break;
                    }
                    case "return_book_copy": {
                        UserService.returnCopy(inputs[1]);
                        break;
                    }
                    case "print_borrowed": {
                        UserService.getBorrowedBooks(inputs[1]);
                        break;
                    }
                    case "exit":{
                        return;
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}