package VideoGame_Final_Proyect;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//Java project
public class VideoGameScoresApp {
     static void main() throws IOException {
         //Create Scoreboard
         Scoreboard myScoreboard = new Scoreboard();
/*
  Load data files on start, we will call two methods here to read data from files
 Show menu loop and collect user’s choice with Scanner

test for Game.fromDataLine method
         Game newObj = new Game();
         Game obj2 = newObj.fromDataLine("6,Hello,Hola,Bonjour,Salamalecum");
         System.out.println(obj2);
test for Students.getTotal method & Students.toString method
         Students newObj = new Students();
         System.out.println(newObj.getTotal());
         System.out.println(Arrays.toString(newObj.getScores()));
*/
Scoreboard scoreboard = new Scoreboard();
scoreboard.loadGame("/Users/ricardo/IdeaProjects/VideoGame-Repository-Java-Proyect/src/VideoGame_Final_Proyect/games.txt");
scoreboard.loadStudents("/Users/ricardo/IdeaProjects/VideoGame-Repository-Java-Proyect/src/VideoGame_Final_Proyect/scores.txt");
         for (int i = 0; i < 50; i++) {
             System.out.println();
         }

         while(true) {
             int choice = -1;
             do {
                 System.out.println("------------------------------------------------------------------------------------------------------");
                 System.out.println("=======================================================================================================");
                 printMenu();
                 System.out.println("=======================================================================================================");
                 System.out.println("------------------------------------------------------------------------------------------------------");

                 choice = Utilities.getUserChoice("Please, enter choice: ");
             } while ((choice < 0) || (choice > 8));
             switch (choice) {
                 case 0:
                     System.exit(0);
                     for (int i = 0; i < 4; i++) {
                         System.out.println();
                     }
                     break;
                 case 1:
                     handleListGames(scoreboard);
                     for (int i = 0; i < 4; i++) {
                         System.out.println();
                     }
                     break;
                 case 2:
                     handleListStudents(scoreboard);
                     System.out.println();
                     break;
                 case 3:
                     handleStudentReport(scoreboard);
                     for (int i = 0; i < 4; i++) {
                         System.out.println();
                     }
                     break;
                 case 4:
                     handleTopNforAgame(scoreboard);
                     for (int i = 0; i < 4; i++) {
                         System.out.println();
                     }
                     break;
                 case 5:
                     handleUpdateStudentScore(scoreboard);
                     break;
                 case 6:
                     handleGameStats(scoreboard);
                     break;
                 case 7:
                     handleAddNewStudent(scoreboard);
                     break;
                 case 8:
                     HandleSaveData(scoreboard);
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
    private static void handleListGames(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle List Games...");
        System.out.println("------------------------------------------------------------------------------------------------------");
        sb.listGame();
        System.out.println("------------------------------------------------------------------------------------------------------");


    }   private static void handleListStudents(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle List Students...");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        sb.listStudents();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }
    private static void handleStudentReport(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle Student Report...");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        sb.listStudents();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter new user ID");
        String studentID = input.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        //Find student object by ID
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        Students studentObj = sb.findStudentsId(studentID);
        //Print the report for the student
        System.out.println("==============================================================================================================");
        System.out.println("Repport for " + studentObj);
        int tot = studentObj.getTotal();
        System.out.println("Total: " + tot);
        double avg = studentObj.getAverage();
        System.out.println("Average: " + avg);
        System.out.println("==============================================================================================================");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }

    private static void handleTopNforAgame(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handling top students for desired game...");
        sb.listGame();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter game ID: ");
        int gameId = in.nextInt();
        int gameIndex = sb.findGameIndexById(gameId);
        System.out.println("Top N: ");
        int topN = in.nextInt();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("==============================================================================================================");
        sb.showTopNForGame(gameIndex, topN);
        System.out.println("==============================================================================================================");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

    }

    private static void handleUpdateStudentScore(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle Update Student Score...");
        System.out.println("Handle Game Stats...");
        sb.listStudents();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        String studentID = input.nextLine();
        sb.listGame();
        System.out.println("Enter game ID: ");
        int gameID = input.nextInt();
        Students currentStudent = sb.findStudentsId(studentID);
        int gameIndex = sb.findGameIndexById(gameID);
        System.out.println("Student with ID: " + currentStudent.getName() + " has a score of " + currentStudent.getScoreAt(gameIndex) +" in Game with id " + gameID);
        System.out.println("Enter new score (>=0): ");
        int newScore = input.nextInt();
        sb.updateScore(studentID,gameIndex,newScore);

    }   private static void handleGameStats(Scoreboard sb) throws FileNotFoundException {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        sb.listGame();
        System.out.println("------------------------------------------------------------------------------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.println("Enter game ID: ");
        int gameID = input.nextInt();
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("=======================================================================================================");
        sb.computeStatsForGame(gameID);
        System.out.println("=======================================================================================================");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
    private static void handleAddNewStudent(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle Add New Student...");
        sb.listStudents();
        System.out.println("DO NOT USE THE NAME ID OR NAME ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        String studentID = input.nextLine();
        System.out.println("Enter student name: ");
        String studentName  = input.nextLine();
        int[] newScore = new int[10];
        Students newStudent = new Students(studentID, studentName, newScore);
        sb.addStudent(newStudent);
    }
    private static void HandleSaveData(Scoreboard sb) throws IOException {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle Save Data...");
        FileWriter text = new FileWriter("/Users/ricardo/IdeaProjects/VideoGame-Repository-Java-Proyect/src/VideoGame_Final_Proyect/scores_2.txt", false);
        PrintWriter pw = new PrintWriter(text);
        for (int i =0 ; i<sb.getStudentCount(); i++){
            pw.println(sb.getStudents()[i].toDataLine());
        }
        FileWriter text_1 = new FileWriter("/Users/ricardo/IdeaProjects/VideoGame-Repository-Java-Proyect/src/VideoGame_Final_Proyect/games_2.txt", false);
        PrintWriter pw_1 = new PrintWriter(text_1);
        for (int i =0 ; i<10; i++){
            pw_1.println(sb.getGames()[i].toDataLine());
        }
        pw.close();
        pw_1.close();
    }


}

