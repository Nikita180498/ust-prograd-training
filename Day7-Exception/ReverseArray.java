package Day5;
import java.lang.reflect.Method;
class Printer<T>{
    public <T> void printArray(T[] size) {
        for (T element : size) {
            System.out.print(element);
        }
    }
}
public class ReverseArray {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1,2,3,4};
        String[] stringArray = { "Hello","World","?"};

        myPrinter.printArray( intArray );
        myPrinter.printArray( stringArray );

        System.out.println("After Reversing: ");
        for(int i=intArray.length-1;i>=0;i--)
            System.out.print(intArray[i]+ " ");
        System.out.println("\n");
        for (int i=stringArray.length-1;i>=0;i--)
            System.out.print(stringArray[i]+ " ");

    }
}


