package service;

import model.Book;
import model.Library;
import model.Rack;
import repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibraryService {
    static Library library;
    public static void createLibrarySystem(String libraryId,int noOfRacks){
        library=new Library(libraryId);
        List<Rack> rackList=new ArrayList<>();
        for(int i=0;i<noOfRacks;i++){
            Rack rack=new Rack(i,5);
            rackList.add(rack);
            LibraryRepository.rackBookMap.put(rack,new ArrayList<>());
        }
        library.setRackList(rackList);
        System.out.println("Library created " +library.getLibraryId());
        System.out.println("Racks Available "+library.getRackList().size());

    }

}
