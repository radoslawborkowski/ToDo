package Model;

import java.io.*;

public class Task  implements Serializable{
    String title;
    String description;
    int priority;
    boolean done = false;

    public Task(String title, String description, int priority) throws FileNotFoundException {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void finish(){
        this.setDone(true);
    }


    public void editAll(String title, String description, int priority){
        setTitle(title);
        setDescription(description);
        setPriority(priority);
    }


    @Override
    public String toString() {
        return "\n_________________\n"+
                "\u001B[36m"+title.toUpperCase()+"\u001B[31m"+"   |" + priority+
                "\n"+ "\u001B[33m"+
                description+
                "\n------------\n"+"\u001B[36m"+
                "Done?: "+done+"\u001B[0m"+
                "\n\n#################\n";
    }
}
