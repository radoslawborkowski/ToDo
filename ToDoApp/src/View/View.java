package View;

import Controller.TaskListControl;
import java.io.FileNotFoundException;


public class View {
    public static void mainInterface(TaskListControl taskListControl) throws FileNotFoundException {
        String menu = """
                *********************************
                *               To Do           *
                *   Opcje:                      *
                *   1. Wyœwietl zadania.        *
                *   (Sortowanie domyœlne).      *
                *   2. Ukoñcz zadanie.          *
                *   3. Edytuj zadanie.          *
                *   4. Usuñ zadanie.            *
                *   5. Dodaj zadanie.           *
                *                               *
                *********************************
                
                """;
        System.out.println(menu);
        System.out.print("Wybór: ");
        int choiceMenu = NumberFromUser.validation(1,6);

       Navigation.navigation(taskListControl,choiceMenu);
    }

    public static void displayTasks(TaskListControl taskListControl){
        for (int i = 0; i<taskListControl.size(); i++) {
            System.out.print("\u001B[35m"+ "index: "+ i);
            System.out.println(taskListControl.get(i).toString());
        }
    }
}
