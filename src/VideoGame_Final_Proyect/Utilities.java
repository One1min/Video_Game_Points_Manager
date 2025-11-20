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
    public  static void showArrays(int[] list){
        System.out.print("{");
        for (int i : list) {
            System.out.print(" " + i + " ");
        }
        System.out.println("}");
    }
}
