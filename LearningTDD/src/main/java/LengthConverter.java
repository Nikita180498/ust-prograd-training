public class LengthConverter {

    double magnitude1;
    double magnitude2;

    LengthConverter(double magnitude1){

        if(magnitude1 <= 0){

            throw new IllegalArgumentException("Centimeter should not be zero or negative");
        }
        this.magnitude1 = magnitude1;
    }

    LengthConverter(double magnitude1, double magnitude2){
       if (magnitude1 <= 0 || magnitude2 <= 0){

           throw new IllegalArgumentException("Value can't be zero or less than zero");
       }
        this.magnitude1 = magnitude1;
        this.magnitude2 = magnitude2;
    }

    public double calculateCentimeter(){
        return magnitude1;
    }
    public double calculateMeter()
    {
       return magnitude1 / 100;
    }
    public double calculateKilometer()
    {
        return magnitude1 / 100000;
    }

    public double addingMeterAndCentimeterGivesMeter(){

        return magnitude1 + (magnitude2 / 100);
    }
    public double addingCentimeterAndKilometerGivesCentimeter(){

        return magnitude1 + (magnitude2 * 100000);
    }
    public double subtractingMeterAndCentimeterGivesMeter(){

        return magnitude1 - (magnitude2 / 100);
    }
    public double subtractingCentimeterAndMeterGivesCentimeter(){

        return magnitude1 - (magnitude2 * 100);
    }
}