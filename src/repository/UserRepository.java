package repository;

import model.Book;
import model.User;

import java.util.*;

public class UserRepository {
    static public Map<String, List<Book>> userBookMap;

    public UserRepository() {
        this.userBookMap = new HashMap<>();
    }

    static public List<Book> getBooksForUser(User user) {
        return userBookMap.get(user);
    }

    public void setUserBookMap(String user, Book book) {
        if(userBookMap.containsKey(user)){
            userBookMap.get(user).add(book);
            return;
        }
        userBookMap.put(user,new ArrayList<>((Collection) book));
    }
}
