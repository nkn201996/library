package model;

import java.util.List;

public class Library {
    String libraryId;
    List<Rack> rackList;

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public List<Rack> getRackList() {
        return rackList;
    }

    public void setRackList(List<Rack> rackList) {
        this.rackList = rackList;
    }

    public Library(String libraryId) {
        this.libraryId = libraryId;
    }
}
