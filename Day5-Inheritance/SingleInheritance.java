package Inheritance;

class Base{
    Base(){
        System.out.println("Base Class");
    }
}

class Derived extends Base{
    Derived(){
        System.out.println("Derived Class");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Derived derived = new Derived();
    }


}
