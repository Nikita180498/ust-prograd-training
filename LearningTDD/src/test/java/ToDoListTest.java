import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    ToDoList toDoList = new ToDoList();

   @BeforeEach
    public void checkTheAddedItem() {
        toDoList.addItemToList("First",true);
        toDoList.addItemToList("Second", false);
        toDoList.addItemToList("Third", true);
        toDoList.addItemToList("Fourth", false);
    }

    @Test
    public void checkItemIsAddedOrNot() {
        String actualList = toDoList.checkList("First");
        assertEquals("First", actualList);
    }

    @Test
    public void checkRemoveItemFromTODOList(){
       boolean actualList = toDoList.removeItemFromToDoList("Second");
       assertEquals(true, actualList);
    }

    @Test
    public void checkUnRemoveItemAddedToList(){
        boolean actualList = toDoList.getRemovedItem("Second");
        assertEquals(true, actualList);
    }

    @Nested
    public class ToggleBetweenCompletedOrNotCompleted{
        @Test
        public void checkIfTaskIsCompleted(){

           boolean actualList = toDoList.completedOrNotCompleted("First");
           assertEquals(true,actualList);
        }

        @Test
        public void checkIfTaskIsNotCompleted(){
            boolean actualList = toDoList.completedOrNotCompleted("Second");
            assertEquals(false,actualList);
        }
    }
}
