package Day6;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("BMW");
        linkedList.add("Benz");
        linkedList.add("Toyota");
        linkedList.add("Volkswagen");
        linkedList.remove(2);
        System.out.println(linkedList.lastIndexOf("Benz"));
        linkedList.addLast("Honda");
        linkedList.set(2,"Baleno");

//        linkedList.forEach(car -> System.out.println(car));

        int ch;
        System.out.println("Enter index: ");
        int n=sc.nextInt();
        do{
            System.out.println("\n1. Display \n2. Remove\n3. Get first\n4. Clone\n5. Get last ");
            System.out.println("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> System.out.println("Original Linked list:\n" + linkedList);
                case 2 -> {
                    System.out.println(linkedList.remove(n));
                    System.out.println("After removing:\n" + linkedList);
                }
                case 3 -> System.out.println("First element is:\n" + linkedList.getFirst());
                case 4 -> System.out.println("Cloned LinkedList:\n" + linkedList.clone());
                case 5 -> System.out.println("First element is:\n" + linkedList.getLast());
            }
        }while(ch!=6);
    }

}
