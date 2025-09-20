public class Movie {
    private String title;
    private String genre;
    private String director;
    private int yearReleased;
    private boolean checkedOut;
    private boolean late;
    private int movieDurationInMinutes;
    public Movie(String title, String genre, String director, int yearReleased, int movieDurationInMinutes) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.yearReleased = yearReleased;
        this.checkedOut = false;
        this.late = false;
        this.movieDurationInMinutes = movieDurationInMinutes;
    }
    public Movie (String title, String director){
        this.title = title;
        this.director = director;
        this.yearReleased = 1995;
        this.genre = "N/A";
        this.movieDurationInMinutes = 60;
        this.checkedOut = false;
        this.late = false;
    }
    public Movie (){
        this.title = "N/A";
        this.genre = "N/A";
        this.director = "N/A";
        this.yearReleased = 1995;
        this.movieDurationInMinutes = 60;
        this.checkedOut = false;
        this.late = false;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
    }
    public String getDirector(){
        return director;
    }
    public int getYearReleased(){
        return yearReleased;
    }
    public boolean isCheckedOut(){
        return checkedOut;
    }
    public boolean isLate(){
        return late;
    }
    public int getMovieDurationInMinutes(){
        return movieDurationInMinutes;
    }
    public void setMovieDurationInMinutes(int movieDurationInMinutes){
        this.movieDurationInMinutes = movieDurationInMinutes;
    }
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }
    public void setLate(boolean late){
        this.late = late;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setYearReleased(int yearReleased){
        this.yearReleased = yearReleased;
    }
}
