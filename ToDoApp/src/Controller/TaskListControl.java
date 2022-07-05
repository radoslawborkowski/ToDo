package Controller;
import Model.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class TaskListControl extends ArrayList<Task> {

    String pathToTasks = "src/Model/Tasks";


    public String getPathToTasks() {
        return pathToTasks;
    }


    public void writeTasksToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(pathToTasks);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            System.out.println("Zapisano!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object readTasksFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream(pathToTasks);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object object = objectIn.readObject();

            System.out.println("Wczytano");
            objectIn.close();
            return object;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
