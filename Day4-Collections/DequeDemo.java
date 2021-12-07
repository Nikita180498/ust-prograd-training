package Day6;

import java.util.*;
class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Book> deque = new ArrayDeque<Book>();
        //Creating Books
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Java","James J. Gosling","Addison-Wesley",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);

        deque.add(b1);
        deque.add(b2);
        deque.add(b3);

        for(Book b:deque){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}