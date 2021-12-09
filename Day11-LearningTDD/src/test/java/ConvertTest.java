import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    Convert convert;


    //************************* Centimeter ****************************

    @Nested
    class TestCentimeter{
        @Test
        public void convertCentimeterIntoCentimeterOfOneIsOne(){
            convert = new Convert(1);
            double actualCentimeter = convert.calculateCentimeter();
            double expectedCentimeter =1;
            assertEquals(expectedCentimeter,actualCentimeter);
        }

        @Test
        public void convertCentimeterIntoMeterOfZeroGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Convert(0));
        }

        @Test
        public void convertCentimeterIntoMeterOfMinusTwoGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Convert(-2));
        }

    }



    //************************* Meter ****************************

    @Nested
    class TestMeter{
        @Test
        public void convertCentimeterIntoMeterOfOneIsPointZeroOne(){
            convert = new Convert(1);
            double actualMeter = convert.calculateMeter();
            double expectedMeter =0.01;
            assertEquals(expectedMeter,actualMeter);
        }

        @Test
        public void convertCentimeterIntoMeterOfZeroGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Convert(0));
        }

        @Test
        public void convertCentimeterIntoMeterOfMinusTwoGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Convert(-2));
        }

    }

    //********************** Kilometer *************************

    @Nested
    class TestKilometer{
        @Test
        public void convertCentimeterIntoKilometerOfOneIsPointOneEMinusFive(){
            convert = new Convert(1);
            double actualKilometer = convert.calculateKilometer();
            double expectedKilometer =1e-5;
            assertEquals(expectedKilometer,actualKilometer);
        }

        @Test
        public void convertCentimeterIntoKilometerOfZeroGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new Convert(0));
        }

        @Test
        public void convertCentimeterIntoKilometerOfMinusFiveGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new Convert(-5));
        }

    }

}