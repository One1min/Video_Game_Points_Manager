package VideoGame_Final_Proyect;

public class Game {
    int id;
    private String title;
    private String genre;
    private String publisher;

    public Game(int id, String title, String genre, String publisher) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
    }
    public Game() {
        this.id = 0;
        this.title = null;
        this.genre = null;
        this.publisher = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String toString(){
        return String.format("%5d  -   %20s   -   (%15s , %15s)", this.getId(), this.getTitle(), this.getGenre(), this.getPublisher());
    }
    public boolean equals(Game parameters){
return this.getTitle().equalsIgnoreCase(parameters.getTitle()) &&
        this.getGenre().equalsIgnoreCase(parameters.getGenre()) &&
        this.getPublisher().equalsIgnoreCase(parameters.getPublisher());
    }
    public  String toDataLine(){
        return this.getId() +","+ this.getTitle() +","+ this.getGenre() + "," + this.getPublisher();
    }
    public static Game fromDataLine(String line){
        String[] parts = line.split(",");
        for(int i = 0; i<parts.length; i++){
            System.out.println("Part " + (i+1) + ": " + parts[i]);
        }
        int id = Integer.parseInt(parts[0]);
        return new Game(id, parts[1],parts[2],parts[3]);
    }
}
