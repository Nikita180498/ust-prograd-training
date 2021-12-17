import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthConvertTest {

    LengthConverter convert;

    //************************* Centimeter ****************************

    @Nested
    class TestCentimeter{
        @Test
        public void convertCentimeterIntoCentimeterOfOneIsOne(){
            convert = new LengthConverter(1);
            double actualCentimeter = convert.calculateCentimeter();
            double expectedCentimeter =1;
            assertEquals(expectedCentimeter,actualCentimeter);
        }

        @Test
        public void convertCentimeterIntoMeterOfZeroGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(0));
        }

        @Test
        public void convertCentimeterIntoMeterOfMinusTwoGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(-2));
        }

    }



    //************************* Meter ****************************

    @Nested
    class TestMeter{
        @Test
        public void convertCentimeterIntoMeterOfOneIsPointZeroOne(){
            convert = new LengthConverter(1);
            double actualMeter = convert.calculateMeter();
            double expectedMeter =0.01;
            assertEquals(expectedMeter,actualMeter);
        }

        @Test
        public void convertCentimeterIntoMeterOfZeroGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(0));
        }

        @Test
        public void convertCentimeterIntoMeterOfMinusTwoGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(-2));
        }

    }

    //********************** Kilometer *************************

    @Nested
    class TestKilometer{
        @Test
        public void convertCentimeterIntoKilometerOfOneIsPointOneEMinusFive(){
            convert = new LengthConverter(1);
            double actualKilometer = convert.calculateKilometer();
            double expectedKilometer =1e-5;
            assertEquals(expectedKilometer,actualKilometer);
        }

        @Test
        public void convertCentimeterIntoKilometerOfZeroGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(0));
        }

        @Test
        public void convertCentimeterIntoKilometerOfMinusFiveGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(-5));
        }

    }


    //********************** Addition Of Magnitude *************************

    @Nested
    class TestAdditionOfMagnitude{
        @Test
        public void checkAdditionOfOneMeterAndHundredCentimeterGivesTwoMeter(){
            convert = new LengthConverter(1,100);
            double actualMagnitude = convert.addingMeterAndCentimeterGivesMeter();
            double expectedMagnitude = 2;
            assertEquals(actualMagnitude,expectedMagnitude);
        }

        @Test
        public void checkAdditionOfTwoHundredCentimeterAndOneKilometerGivesTOneLacCentimeter(){
            convert = new LengthConverter(200,1);
            double actualMagnitude = convert.addingCentimeterAndKilometerGivesCentimeter();
            double expectedMagnitude = 100200;
            assertEquals(actualMagnitude,expectedMagnitude);
        }

        @Test
        public void checkAdditionOfZeroMeterAndHundredCentimeterGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(0,100));
        }

        @Test
        public void checkAdditionOfMeterAndHundredCentimeterGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(200,-1));
        }

    }


    //********************** Subtraction Of Magnitude *************************

    @Nested
    class TestSubtractionOfMagnitude{
        @Test
        public void checkSubtractionOfOneMeterAndFiftyCentimeterGivesTwoMeter(){
            convert = new LengthConverter(1,50);
            double actualMagnitude = convert.subtractingMeterAndCentimeterGivesMeter();
            double expectedMagnitude = 0.5;
            assertEquals(actualMagnitude,expectedMagnitude);
        }

        @Test
        public void checkSubtractionOfTwoThousandCentimeterAndOneMeterGivesNineteenHundredCentimeter(){
            convert = new LengthConverter(2000,1);
            double actualMagnitude = convert.subtractingCentimeterAndMeterGivesCentimeter();
            double expectedMagnitude = 1900;
            assertEquals(actualMagnitude,expectedMagnitude);
        }

        @Test
        public void checkAdditionOfZeroMeterAndHundredCentimeterGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(0,50));
        }

        @Test
        public void checkAdditionOfMeterAndHundredCentimeterGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new LengthConverter(2000,-1));
        }

    }


}













//Task - 1 --->//As an architect, I want to be able to check if 1 cm is equal to 1 cm.
//As an architect, I want to be able to check if 1 m is equal to 100 cm, and 100 cm is equal to 0.001 km.

//Task - 2 --->//As an architect, I want to be able to know that 1 m + 100 cm = 2 m, or 200 cm + 1 km = 100200 cm.
//As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m, 2000 cm – 1 m = 1900 cm.
