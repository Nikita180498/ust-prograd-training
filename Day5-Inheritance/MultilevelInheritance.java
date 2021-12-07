package Inheritance;

class A{
    A(){
        System.out.println("Class A");
    }
}

class B extends A{
    B(){
        System.out.println("Class B");
    }
}

class C extends B{
    C(){
        System.out.println("Class C");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        C c = new C();
    }
}
