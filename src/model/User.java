package model;

import java.util.List;

public class User {
    private String userId;
    private String userName;
    private List<String> borrowedCopyIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getBorrowedCopyIdList() {
        return borrowedCopyIdList;
    }

    public void setBorrowedCopyIdList(List<String> borrowedCopyIdList) {
        this.borrowedCopyIdList = borrowedCopyIdList;
    }

    public User(String userId) {
        this.userId = userId;
    }
}
