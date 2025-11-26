package VideoGame_Final_Proyect;

import java.util.Arrays;

public class Students {
    private String id;
    private String name;
    private int[] scores = new int[10];

    public Students(String id, String name, int[] scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public Students() {
        this.id = "";
        this.name = "";
        Arrays.fill(this.scores, 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int getTotal() {
        int ans = 0;
        for (int score : this.scores) {
            ans += score;
        }
        return ans;
    }

    public double getAverage() {
        return (double) this.getTotal() / this.scores.length;
    }

    public String toString() {
        return String.format("%s     %s     %s", this.getId(), this.getName(), Arrays.toString(this.getScores()));
    }

    public static Students fromDataLine(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String name = parts[1];
        int[] number = new int[10];
        for (int i = 2; i < 12; i++) {
            number[i - 2] = Integer.parseInt(parts[i].trim());
        }
        return new Students(id, name, number);

    }

    public boolean equals(Students parameters) {
        for (int i = 0; i < parameters.getScores().length; i++) {
            if (this.scores[i] != parameters.getScores()[i]) {
                return false;
            }
        }
        return this.getId().equalsIgnoreCase(parameters.getId())
                && this.getName().equalsIgnoreCase(parameters.getName());
    }

    public String toDataLine() {
        String result = getId() + "," +getName();
        for (int i = 0; i< this.getScores().length; i++){
            result = result + "," + getScores()[i];
        }
        return result;
    }
}
