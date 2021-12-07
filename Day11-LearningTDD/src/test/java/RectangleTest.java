import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    public void setup(){
        rectangle = new Rectangle();
    }

    //****************** Area Of Rectangle *******************

    @Nested
    class TestingAreaFunction {
        @Test
        public void areaOfRectangleOfLengthFiveAndBreadthFiveIsTwentyFive() {

            double answer = rectangle.area(5, 5);
            double expected = 25;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void areaOfRectangleOfLengthFiveAndBreadthTenIsFifty() {

            double answer = rectangle.area(5, 10);
            double expected = 50;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void areaOfRectangleOfLengthFourAndBreadthFiveIsTwenty() {

            double answer = rectangle.area(4, 5);
            double expected = 20;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void areaOfRectangleOfLengthTwoAndBreadthFourIsEight() {

            double answer = rectangle.area(2, 4);
            double expected = 8;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void areaOfRectangleOFLengthFiveAndBreadthZeroArithmeticException() {
            Assertions.assertThrows(ArithmeticException.class, () -> rectangle.area(5, 0));
        }

        @Test
        public void areaOFRectangleOfLengthFiveAndBreadthMinusTwoArithmeticException() {
            Assertions.assertThrows(ArithmeticException.class, () -> rectangle.area(5, -2));
        }
    }
    //***************** Perimeter Of Rectangle *******************
    @Nested
    class TestingPerimeterFunction {
        @Test
        public void perimeterOfRectangleOfLengthFiveAndBreadthFiveIsTwentyFive() {

            double answer = rectangle.perimeter(5, 5);
            double expected = 20;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void perimeterOfRectangleOfLengthFiveAndBreadthTenIsFifty() {

            double answer = rectangle.perimeter(5, 10);
            double expected = 30;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void perimeterOfRectangleOfLengthFourAndBreadthFiveIsTwenty() {

            double answer = rectangle.perimeter(4, 5);
            double expected = 18;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void perimeterOfRectangleOfLengthTwoAndBreadthFourIsEight() {

            double answer = rectangle.perimeter(2, 4);
            double expected = 12;
            Assertions.assertEquals(answer, expected);
        }

        @Test
        public void perimeterOfRectangleOFLengthFiveAndBreadthZeroArithmeticException() {
            Assertions.assertThrows(ArithmeticException.class, () -> rectangle.perimeter(5, 0));
        }

        @Test
        public void perimeterOFRectangleOfLengthFiveAndBreadthMinusTwoArithmeticException() {
            Assertions.assertThrows(ArithmeticException.class, () -> rectangle.perimeter(5, -2));
        }
    }


}
