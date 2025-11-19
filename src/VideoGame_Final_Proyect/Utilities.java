package VideoGame_Final_Proyect;

import java.util.Scanner;

public class Utilities {
    public static int getUserChoice(String prompt) {
        int choice = 0;
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        return choice;

    }
}
