package Day6;
import java.util.*;
class ArrayListDemo{
    public static void main(String args[]){
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("Steve");
        arrayList.add("Tim");
        arrayList.add("Lucy");
        arrayList.add("Pat");
        arrayList.add("Angela");
        arrayList.add("Tom");

        System.out.println(arrayList);

        arrayList.add(3, "Steve");

        System.out.println(arrayList);
    }
}
