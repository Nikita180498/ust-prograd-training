public class Rectangle {

    //************* Area ********************

    public double area(double length, double breadth) {

        if(length == 0 || breadth==0){
            throw new ArithmeticException("Length or breadth can't be Zero");
        }

        if(length <0 || breadth <0){
            throw new ArithmeticException("Length or breadth can't be Negative");
        }

        return length * breadth;

    }

    //************** Perimeter ***************

    public double perimeter(double length, double breadth){
        if(length == 0 || breadth==0){
            throw new ArithmeticException("Length or breadth can't be Zero");
        }

        if(length <0 || breadth <0){
            throw new ArithmeticException("Length or breadth can't be Negative");
        }

        return 2 * (length + breadth);
    }


}
