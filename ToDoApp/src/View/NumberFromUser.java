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
                    System.out.print("\nWyb�r musi by� z przedzia�u: " + minValue + " - " + maxValue+"\nWyb�r: ");
                }
                else return  userValueValidate;
            } catch (Exception e) {
                System.out.print("\nPodaj liczb�!\nWyb�r: ");
            }
        }
        while (true);
    }
}
