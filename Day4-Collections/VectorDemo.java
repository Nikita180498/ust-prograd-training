package Day6;

import java.util.Collections;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(8);
        vector.add("Tomato");
        vector.add("Potato");
        vector.addElement("Beans");
        vector.add("Onion");
        vector.removeElement("Beans");
//        vector.forEach(veg -> System.out.println(veg));


        System.out.println("Vector elements before sorting:");
        for (Object object : vector) {
            System.out.println(object);
        }
        Collections.sort(vector);

        System.out.println("Vector elements after sorting:");
        for (Object elements : vector) {
            System.out.println(elements);
        }
    }
}
