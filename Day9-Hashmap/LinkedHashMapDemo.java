package Day7;

import java.util.*;

class Book {

    int id;
    String name,author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;

    }
}

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap<Integer,Book> map=new LinkedHashMap<Integer,Book>();

        Book b1=new Book(101,"Let us C","Yashwant Kanetkar");
        Book b2=new Book(102,"Data Communications & Networking","Forouzan");
        Book b3=new Book(103,"Operating System","Galvin");

        map.put(2,b2);
        map.put(1,b1);
        map.put(3,b3);


        for(Map.Entry<Integer, Book> entry:map.entrySet()){
            int key=entry.getKey();
            Book b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author);


        }
    }
}