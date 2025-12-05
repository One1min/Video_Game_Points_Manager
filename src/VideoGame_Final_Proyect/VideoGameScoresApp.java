package VideoGame_Final_Proyect;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//Java project
public class VideoGameScoresApp {
     static void main() throws FileNotFoundException {
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
                 printMenu();
                 choice = Utilities.getUserChoice("Please, enter choice: ");
             } while ((choice < 0) || (choice > 8));
             switch (choice) {
                 case 0:
                     System.exit(0);
                     break;
                 case 1:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleListGames(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 2:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleListStudents(scoreboard);
                     break;
                 case 3:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleStudentReport(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 4:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleTopNforAgame(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 5:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleUpdateStudentScore(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 6:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleGameStats(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 7:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     handleAddNewStudent(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     break;
                 case 8:
                     System.out.println("------------------------------------------------------------------------------------------------------");
                     HandeSaveData(scoreboard);
                     System.out.println("------------------------------------------------------------------------------------------------------");
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

    }   private static void handleListStudents(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle List Students...");
        sb.listStudents();

    }   private static void handleStudentReport(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Handle Student Report...");
        sb.listStudents();
        Scanner input = new Scanner(System.in);
        System.out.println("===============================================================================================================");
        System.out.println("Enter new user ID");
        String studentID = input.nextLine();
        System.out.println("===============================================================================================================");

        //Find student object by ID
        System.out.println("------------------------------------------------------------------------------------------------------");
        Students studentObj = sb.findStudentsId(studentID);
        //Print the report for the student
        System.out.println("Repport for " + studentObj);
        int tot = studentObj.getTotal();
        System.out.println("Total: " + tot);
        double avg = studentObj.getAverage();
        System.out.println("Average: " + avg);
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("===============================================================================================================");
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
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------");
        sb.showTopNForGame(gameIndex, topN);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------");

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
        System.out.println("Enter game ID");
        int gameID = input.nextInt();
        Students currentStudent = sb.findStudentsId(studentID);
        int gameIndex = sb.findGameIndexById(gameID);
        System.out.println("Student with ID: " + currentStudent.getName() + " has a score of " + currentStudent.getScoreAt(gameIndex) +" in Game with id " + gameID);
        System.out.println("Enter new score (>=0): ");
        int newScore = input.nextInt();
        sb.updateScore(studentID,gameIndex,newScore);

    }   private static void handleGameStats(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    private static void handleAddNewStudent(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.println("Handle Add New Student...");

    }   private static void HandeSaveData(Scoreboard sb) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Hande Save Data...");
        
    }


}

