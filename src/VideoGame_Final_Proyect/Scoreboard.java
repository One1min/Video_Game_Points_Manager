package VideoGame_Final_Proyect;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Scoreboard {
    private static final int MAX_STUDENTS = 100;
    private int studentCount;
    private Game[] games;
    private Students[] students;
    //  inner class
class Stats{
    public int min;
    public int max;
    public double avg;

}

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
            System.out.println("===============================================================================================================");
        }
        myScanner.close();
    }
    public void loadStudents(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
        int i =0;

        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            Students obj = Students.fromDataLine(line);
            this.students[i]= obj;
            System.out.println("The line is: " + line);
            System.out.println(obj);
            System.out.println("===============================================================================================================");
            i++;
        }
        myScanner.close();
        this.studentCount = i;
    }
public void listGame(){
        for (Game g : this.getGames()){
            System.out.println(g);
        }
}
    public void listStudents() {
        System.out.println("===============================================================================================================");
        for (int i = 0; i < this.studentCount; i++) {
            System.out.println(getStudents()[i]);
            System.out.println("===============================================================================================================");
        }
    }
        public Students findStudentsId(String id){
            Students studentsObj = null;
            for(int i =0; i<this.studentCount; i++){
                Students s = this.getStudents()[i];
                if (id.equals(s)){
                    studentsObj = s;
                    break;
                }
            }
            return studentsObj;
        }
    public int findGameIndexById(int id){
        int foundIndex = -1;
        for(int i =0; i<this.getGames().length; i++){
            Game s = this.getGames()[i];
            if (id == s.getId()){
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }
public void updateScore(String studentId, int gameId, int newScore){
        Students foundStudent = this.findStudentsId(studentId);
        if (foundStudent == null){
            System.out.println("Student with id: " + studentId + "is not found!!!");
        }
        else {
            int [] scores = foundStudent.getScores();
            scores[gameId] = newScore;
        }
}
public Stats computeStatsForGame(int gameIndex){
    // get scores for all students for all the students
    for(int i = 0; i<this.studentCount; i++){
        Students s = this.getStudents()[i];
        int[] allScore = s.getScores();
        int score = allScore[gameIndex];
        System.out.println(score + ", ");
    }
}

}
