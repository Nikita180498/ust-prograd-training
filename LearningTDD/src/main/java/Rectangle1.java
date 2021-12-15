public class Rectangle1 {

    double length;
    double breadth;

    Rectangle1(double length, double breadth){
        if(length <=0 || breadth <=0 ){
            throw new IllegalArgumentException("Length and breadth should not be zero or less than zero");
        }
        this.length = length;
        this.breadth = breadth;
    }
    public double area(){
        return  length * breadth;
    }

    public double perimeter(){
        return  2 * ( length + breadth );
    }
}
