

public class Movie {

    private int rank;
    private String title;
    private int year;

    public Movie(int rank, String title, int year) {
        this.rank = rank;
        this.title = title;
        this.year = year;
    }

    public int getRank() {
        return this.rank;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }
}