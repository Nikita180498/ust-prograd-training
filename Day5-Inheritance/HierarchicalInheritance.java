package Inheritance;

class Parent{
    Parent(){
        System.out.println("A");
    }
}
class Child extends Parent{
    Child(){
        System.out.println("B");
    }
}
class GrandChild extends Parent{
    GrandChild(){
        System.out.println("C");
    }
}

public class HierarchicalInheritance {

    GrandChild grandChild = new GrandChild();

}
