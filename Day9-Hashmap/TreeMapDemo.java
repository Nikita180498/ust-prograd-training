package Day7;

import java.util.Map;
import java.util.TreeMap;

class Books {

    int id;
    String name,author;

    public Books(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;

    }
}

    public class TreeMapDemo {
        public static void main(String[] args) {

            TreeMap<Integer,Book> treeMap=new TreeMap<>();

            Book b1=new Book(101,"Let us C","Yashwant Kanetkar");
            Book b2=new Book(102,"Data Communications & Networking","Forouzan");
            Book b3=new Book(103,"Operating System","Galvin");

            treeMap.put(2,b2);
            treeMap.put(1,b1);
            treeMap.put(3,b3);


            for(Map.Entry<Integer,Book> entry:treeMap.entrySet()){
                int key=entry.getKey();
                Book b=entry.getValue();
                System.out.println(key+" Details:");
                System.out.println(b.id+" "+b.name+" "+b.author);


            }
        }
    }

