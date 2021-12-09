public class Convert {
    double centimeter;

    Convert(double centimeter){

        if(centimeter <= 0){
            throw new IllegalArgumentException("Centimeter should not be zero or negative");
        }
        this.centimeter = centimeter;
    }
    public double calculateCentimeter(){
        return centimeter;
    }
    public double calculateMeter()
    {
       return centimeter / 100;
    }
    public double calculateKilometer()
    {
        return centimeter / 100000;
    }
}
