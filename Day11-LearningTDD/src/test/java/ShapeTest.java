import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    Rectangle1 rectangle1;
    Square square;

    //************************* Rectangle ****************************
    @Nested
    class TestAreaOfRectangle{
        @Test
        public void checkAreaOfRectangleOfLengthTwoAndBreadthFiveGivesTen(){
        rectangle1 = new Rectangle1(2,5);
        double actualArea = rectangle1.area();
        double expectedArea =10;
        assertEquals(expectedArea,actualArea);
        }

        @Test
        public void checkAreaOfRectangleOfLengthMinusTwoAndBreadthFiveGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Rectangle1(-2,5));
        }

    }
    @Nested
    class TestPerimeterOfRectangle{
        @Test
        public void checkPerimeterOfRectangleOfLengthTwoAndBreadthFiveGivesFourteen(){
        rectangle1 = new Rectangle1(2,5);
        double actualPerimeter = rectangle1.perimeter();
        double expectedPerimeter =14;
        assertEquals(expectedPerimeter,actualPerimeter);
        }

        @Test
        public void checkPerimeterOfRectangleOfLengthMinusTwoAndBreadthFiveGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new Rectangle1(-2,5));
        }

    }

    //********************** Square *************************
    @Nested
    class TestAreaOfSquare{
        @Test
        public void checkAreaOfSquareOfFiveIsTwentyFive(){
            square = new Square(5);
            double actualArea = square.area();
            double expectedArea =25;
            assertEquals(expectedArea,actualArea);
        }

        @Test
        public void checkAreaOfSquareOfMinusTwoGivesException(){
            assertThrows(IllegalArgumentException.class, () -> new Square(-2));
        }

    }
    @Nested
    class TestPerimeterSquare{
        @Test
        public void checkPerimeterOfSquareOfTwoIs(){
            square = new Square(2);
            double actualPerimeter = square.perimeter();
            double expectedPerimeter =8;
            assertEquals(expectedPerimeter,actualPerimeter);
        }

        @Test
        public void checkPerimeterOfSquareOfMinusFiveGivesException(){

            assertThrows(IllegalArgumentException.class, () -> new Square(-5));
        }

    }

}