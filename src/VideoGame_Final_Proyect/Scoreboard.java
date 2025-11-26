package VideoGame_Final_Proyect;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scoreboard {
    private final int MAX_STUDENTS = 100;
    private int studentCount;
    private Game[] games;
    private Students[] students;

    public Scoreboard() {
        this.games = new Game[10];
        this.studentCount = 0;
        this.students = new Students[this.MAX_STUDENTS];
    }

    public Scoreboard(int studentCount, Game[] games, Students[] students) {
        this.studentCount = studentCount;
        this.students = new Students[this.MAX_STUDENTS];
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }
        this.games = new Game[games.length];
        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    public Students[] getStudents() {
        return students;
    }

    public void setStudents(Students[] students) {
        this.students = new Students[this.MAX_STUDENTS];
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = new Game[games.length];
        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void loadGame(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
        int i =0;

        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
             Game obj = Game.fromDataLine(line);
             this.games[i]= obj;
            System.out.println("The line is: " + line);
            System.out.println(obj);
            i++;
        }
        myScanner.close();
    }
}
