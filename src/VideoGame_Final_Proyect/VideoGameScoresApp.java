package VideoGame_Final_Proyect;

import java.util.Scanner;

public class VideoGameScoresApp {
     static void main() {
         //Create Scoreboard
         Scoreboard myScoreboard = new Scoreboard();
//  Load data files on start, we will call two methods here to read data from files
// Show menu loop and collect user’s choice with Scanner
         while(true) {
             int choice = -1;
             do {
                 printMenu();
                 choice = Utilities.getUserChoice("Please, enter choice: ");
             } while ((choice < 0) || (choice > 8));
             switch (choice) {
                 case 0:
                     System.exit(0);
                     break;
                 case 1:
                     System.out.println("---------------------------------------------------");
                     handleListGames();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 2:
                     System.out.println("---------------------------------------------------");
                     handleListStudents();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 3:
                     System.out.println("---------------------------------------------------");
                     handleStudentReport();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 4:
                     System.out.println("---------------------------------------------------");
                     handleTopNforAgame();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 5:
                     System.out.println("---------------------------------------------------");
                     handleUpdateStudentScore();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 6:
                     System.out.println("---------------------------------------------------");
                     handleGameStats();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 7:
                     System.out.println("---------------------------------------------------");
                     handleAddNewStudent();
                     System.out.println("---------------------------------------------------");
                     break;
                 case 8:
                     System.out.println("---------------------------------------------------");
                     HandeSaveData();
                     System.out.println("---------------------------------------------------");
                     break;
             }
         }
// Validate inputs (IDs exist, scores >= 0)
// Save on command or exit
     }

    private static void printMenu() {
        System.out.println("1. Handle List Games\n" +
                "2. Handle List Students\n" +
                "3. Handle Student Report\n" +
                "4. Handle Top N for Agame\n" +
                "5. Handle Update Student Score\n" +
                "6. Handle Game Stats\n" +
                "7. Handle Add New Student\n" +
                "8. Hande Save Data");

    }
    private static void handleListGames() {
        System.out.println("Handle List Games");

    }   private static void handleListStudents() {
        System.out.println("Handle List Students");

    }   private static void handleStudentReport() {
        System.out.println("Handle Student Report");

    }   private static void handleTopNforAgame() {
        System.out.println("Handle Top N for Agame");

    }   private static void handleUpdateStudentScore() {
        System.out.println("Handle Update Student Score");

    }   private static void handleGameStats() {
        System.out.println("Handle Game Stats");

    }   private static void handleAddNewStudent() {
        System.out.println("Handle Add New Student");

    }   private static void HandeSaveData() {
        System.out.println("Hande Save Data");

    }




}

