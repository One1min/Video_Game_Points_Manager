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

    public static double findAverage(int[] n){
        double accumulator = 0;
        for(int i = 0; i<n.length; i++){
            accumulator = accumulator + n[i];
        }
        return accumulator /n.length;
    }

    public static int findTotal(int[] n){
        int accumulator = 0;
        for(int i = 0; i<n.length; i++){
            accumulator = accumulator + n[i];
        }
        return accumulator;
    }


    public static int findLowest(int[] n){
        int lowest = n[0];
        for(int i = 0; i<n.length; i++) {
            if (n[i] < lowest ){
                lowest = n[i];
            }
        }
        return lowest;
    }

    public static int findHighest(int[] n){
        int highest = n[0];
        for(int i = 0; i<n.length; i++) {
            if (n[i] > highest ){
                highest = n[i];
            }
        }
        return highest;
    }
    public static int[] selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return list;
    }
    public static double[] selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return list;
    }
    }

