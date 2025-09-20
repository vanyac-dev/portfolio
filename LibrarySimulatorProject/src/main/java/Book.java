public class Book {
    String title;
    String author;
    String genre;
    String publisher;
    int pages;
    boolean checkedOut;
    boolean late;
    public Book(String title, String author, String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.genre = genre;
        this.checkedOut = false;
        this.late = false;
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.publisher = "Dream Publishing";
        this.pages = 100;
        this.genre = "N/A";
        this.checkedOut = false;
        this.late = false;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getPages() {
        return pages;
    }
    public String getGenre() {
        return genre;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCheckedOut() { return checkedOut; }
    public boolean isLate() { return late; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPages(int pages) { this.pages = pages; }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public void setLate(boolean late) { this.late = true; }
}
