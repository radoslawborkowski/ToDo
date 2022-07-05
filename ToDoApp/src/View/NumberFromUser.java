package View;

import java.util.Scanner;

public abstract class NumberFromUser {

    public static int validation(int minValue, int maxValue) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                String userValue = scanner.nextLine();
                int userValueValidate = Integer.parseInt(userValue);
                if (userValueValidate < minValue || userValueValidate>maxValue){
                    System.out.print("\nWybór musi byæ z przedzia³u: " + minValue + " - " + maxValue+"\nWybór: ");
                }
                else return  userValueValidate;
            } catch (Exception e) {
                System.out.print("\nPodaj liczbê!\nWybór: ");
            }
        }
        while (true);
    }
}
