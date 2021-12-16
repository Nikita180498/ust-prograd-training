import java.util.ArrayList;
import java.util.PriorityQueue;

public class ToDoList {

    PriorityQueue<String> toDoListCompleted = new PriorityQueue<>();
    PriorityQueue<String> toDoListNotCompleted = new PriorityQueue<>();
    PriorityQueue<String> toDoList1 = new PriorityQueue<>();
    ArrayList<String> removedList = new ArrayList<>();

    public void addItemToList(String item, boolean completedOrNoCompleted){
        if (completedOrNoCompleted){
            toDoListCompleted.add(item);
            toDoList1.addAll(toDoListCompleted);
        }
        else {
            toDoListNotCompleted.add(item);
            toDoList1.addAll(toDoListNotCompleted);
        }
    }

    public String checkList(String item){
        String existingItem = null;
        for(String list : toDoList1){
            if(list == item){
                existingItem = item;
                break;
            }
        }
        return existingItem;
    }

    public boolean removeItemFromToDoList(String item){
     return toDoList1.removeIf(list -> list == item);
    }

    public  boolean getRemovedItem(String item){
        boolean task = false;
        removedList.add(item);
        toDoList1.removeIf(list -> list == item);
        toDoList1.addAll(removedList);
        if(toDoList1.contains(item)){
            task = true;
        }
        return task;
    }

    public boolean completedOrNotCompleted(String completedOrNotCompletedList) {
        boolean task = false;
        for(String list : toDoListCompleted){
            if (list == completedOrNotCompletedList) {
                task = true;

            }
        }
        for(String list : toDoListNotCompleted){
            if (list == completedOrNotCompletedList){
                task = false;

            }
        }
        return task;
    }
}



//1. As a note keeper I want to add items to my todo list.
//2. As a note keeper I want to remove items from my todo list.
//3. As a note keeper, I want to be able to bring back the removed items. (un remove)
//4. As a note keeper, I want to toggle between completed and not completed.