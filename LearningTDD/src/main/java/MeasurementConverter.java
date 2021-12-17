
class MeasurementConverter {

    public double baseToBase(double unit){
        return unit;
    }
    public double kiloToBase(double unit){
        return unit*1000;
    }
    public double baseToKilo(double unit){
        return unit/1000;
    }
    public double centiToCenti(double unit) {
        return unit;
    }
    public double centiToKilo(double unit) {
        return unit / 100000;
    }
    public double baseToCenti(double unit) {
        return unit * 100;
    }
    public double centiToBase(double unit) {
        return unit/100;
    }
    public double kiloToCenti(double unit){
        return unit*100000;
    }
}