package View;

import Controller.TaskListControl;
import java.io.FileNotFoundException;


public class View {
    public static void mainInterface(TaskListControl taskListControl) throws FileNotFoundException {
        String menu = """
                *********************************
                *               To Do           *
                *   Opcje:                      *
                *   1. Wy�wietl zadania.        *
                *   (Sortowanie domy�lne).      *
                *   2. Uko�cz zadanie.          *
                *   3. Edytuj zadanie.          *
                *   4. Usu� zadanie.            *
                *   5. Dodaj zadanie.           *
                *                               *
                *********************************
                
                """;
        System.out.println(menu);
        System.out.print("Wyb�r: ");
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
