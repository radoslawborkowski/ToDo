package View;

import Controller.TaskListControl;
import Model.Task;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static View.View.mainInterface;


public abstract class Navigation {
    static Scanner scanner = new Scanner(System.in);

    public static void sort(TaskListControl taskListControl){
        System.out.print("""
                        Wybierz sortowanie:
                        1. Od najwy¿szego priorytetu
                        2. Od najni¿szego priorytetu
                        3. Alfabetycznie
                        """);
        int choiceSort = NumberFromUser.validation(1,3);
        switch (choiceSort) {
            case 1 -> taskListControl.sort((p1, p2) -> p2.getPriority() - p1.getPriority());
            case 2 -> taskListControl.sort((p1, p2) -> p1.getPriority() - p2.getPriority());
            case 3 -> taskListControl.sort((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
        }
    }

    public static void finishTask(TaskListControl taskListControl){
        System.out.print("Zadanie do ukonczenia");
        int choiceFinish =  NumberFromUser.validation(0,taskListControl.size()-1);
        taskListControl.get(choiceFinish).finish();
        taskListControl.writeTasksToFile();
        System.out.println("Zadanie ukoñczone!");
    }

    public static void editTask(TaskListControl taskListControl){

        System.out.print("Zadanie do edycji: ");
        int choiceToEdit = NumberFromUser.validation(0,taskListControl.size()-1);
        System.out.println("""
                        Co chcesz edytowaæ?
                        1. Tytu³.
                        2. Opis.
                        3. Priorytet.
                        4. Wszystko.
                        """);
        int choiceEditOption = NumberFromUser.validation(1,4);
        String content;
        switch (choiceEditOption) {
            case 1 -> {
                System.out.print("Podaj nowy tytu³: ");
                content = scanner.nextLine();
                taskListControl.get(choiceToEdit).setTitle(content);
                taskListControl.writeTasksToFile();
            }
            case 2 -> {
                System.out.print("Podaj nowy opis: ");
                content = scanner.nextLine();
                taskListControl.get(choiceToEdit).setDescription(content);
                taskListControl.writeTasksToFile();
            }
            case 3 -> {
                System.out.print("Podaj nowy priorytet: ");
                taskListControl.get(choiceToEdit).setPriority(NumberFromUser.validation(0, Integer.MAX_VALUE));
                taskListControl.writeTasksToFile();
            }
            case 4 -> {
                System.out.println("Podaj kolejno tytu³, opis, priorytet: ");
                taskListControl.get(choiceToEdit).editAll(scanner.nextLine(), scanner.nextLine(), NumberFromUser.validation(0, Integer.MAX_VALUE));
                taskListControl.writeTasksToFile();
            }
        }

    }

    public static void deleteTask(TaskListControl taskListControl){
        System.out.print("Zadanie do Usuniecia");
        taskListControl.remove(NumberFromUser.validation(0,taskListControl.size()-1));
        taskListControl.writeTasksToFile();
        System.out.println("Zadanie usuniete!");
    }

    public static void addTask(TaskListControl taskListControl) throws FileNotFoundException {
        System.out.print("Podaj kolejno tytu³, opis, priorytet: ");
        taskListControl.add(new Task(scanner.nextLine(), scanner.nextLine(), NumberFromUser.validation(0, Integer.MAX_VALUE)));
        taskListControl.writeTasksToFile();
    }

    public static void navigation(TaskListControl taskListControl, int choiceMenu) throws FileNotFoundException {
        switch (choiceMenu) {
            case 1 -> {
                sort(taskListControl);
                View.displayTasks(taskListControl);
                mainInterface(taskListControl);
            }
            case 2 -> {
                finishTask(taskListControl);
                mainInterface(taskListControl);
            }
            case 3 -> {
                editTask(taskListControl);
                mainInterface(taskListControl);
            }
            case 4 -> {
                deleteTask(taskListControl);
                mainInterface(taskListControl);
            }
            case 5 -> {
                addTask(taskListControl);
                mainInterface(taskListControl);
            }
        }
    }
}
