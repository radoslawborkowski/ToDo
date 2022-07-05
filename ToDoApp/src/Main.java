import Controller.TaskListControl;
import View.View;

import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        TaskListControl taskListControl = new TaskListControl();

        taskListControl = (TaskListControl) taskListControl.readTasksFromFile();


        View.displayTasks(taskListControl);

        View.mainInterface(taskListControl);


    }
}
