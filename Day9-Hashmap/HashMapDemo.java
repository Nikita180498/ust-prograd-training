package Day7;

import java.util.HashMap;
import java.util.Map;


class Employee {

    String name, city;

    public Employee(String name, String city) {

        this.name = name;
        this.city = city;
    }
}

public class HashMapDemo {
    public static void main(String[] args) {

        Map<Integer, Employee> map = new HashMap<>();

        Employee e1 = new Employee("Nikita", "Solapur");
        Employee e2 = new Employee("Saylee", "Pune");
        Employee e3 = new Employee("Pooja", "Mumbai");

        map.put(2, e2);
        map.put(1, e1);
        map.put(3, e3);


        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            int key = entry.getKey();
            Employee e = entry.getValue();
            System.out.println(key + " Details:");
            System.out.println(e.name + " " + e.city + " ");

        }


    }
}