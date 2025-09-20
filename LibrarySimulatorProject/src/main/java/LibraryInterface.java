import java.util.ArrayList;
import java.util.List;

public class LibraryInterface {
    private int numBooks;
    private int numMovies;
    private final String libraryName;
    private List<Book> books = new ArrayList<>();
    private List<Book> checkedOutBooks = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private List<Movie> checkedOutMovies = new ArrayList<>();

    public LibraryInterface() {
        libraryName = "The Rosebury";
        numBooks = 3;
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", "Classic, Romance, Fiction", 432);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "Classic, Tragedy, Fiction", 180);
        Book book3 = new Book("Invisible Man", "Ralph Ellison", "Random House", "Classic, Fiction, Social Commentary", 581);
        List<Book> tempBooks = new ArrayList<>();
        tempBooks.add(book1);
        tempBooks.add(book2);
        tempBooks.add(book3);
        books = tempBooks;
        numMovies = 3;
        Movie movie1 = new Movie("The Lion King",  "Animation, Adventure, Drama, Family, Musical", "Roger Allers and Rob Minkoff", 1994, 88);
        Movie movie2 = new Movie("Beauty and the Beast", "Animation, Fantasy, Romance, Family, Musical", "Gary Trousdale and Kirk Wise", 1991, 84);
        Movie movie3 = new Movie("Avengers: Infinity War", "Action, Adventure, Sci-Fi, Superhero", "Anthony Russo and Joe Russo", 2018, 149);
        List<Movie> tempMovies = new ArrayList<>();
        tempMovies.add(movie1);
        tempMovies.add(movie2);
        tempMovies.add(movie3);
        movies = tempMovies;
    }
    public LibraryInterface(String libraryName) {
        this.libraryName = libraryName;
        numBooks = 0;
        numMovies = 0;
    }
    public int getNumBooks() {
        return numBooks;
    }
    public int getNumMovies() {
        return numMovies;
    }
    public String getLibraryName() {
        return libraryName;
    }
    public List<Book> getBooks() {
        return books;
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public String getBooksToString() {
        String booksToString = "";
        int counter = 1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                booksToString += counter + ")\nTitle: " + books.get(i).getTitle() + "\n By: " + books.get(i).getAuthor() + "\n Publisher: " + books.get(i).getPublisher() + "\n Genre: " + books.get(i).getGenre() +  "\n Pages:  " + books.get(i).getPages() + "\n";
                counter++;
            }
        }
        return booksToString;
    }
    public String getMoviesToString() {
        String moviesToString = "";
        int counter = 1;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i) != null) {
                moviesToString += counter + ")\nTitle: " + movies.get(i).getTitle() + "\n By: " + movies.get(i).getDirector() + "\n Genre: " + movies.get(i).getGenre() + "\n Year Released: " + movies.get(i).getYearReleased() +  "\n Duration:  " + movies.get(i).getMovieDurationInMinutes() + " minutes\n";
                counter++;
            }
        }
        return moviesToString;
    }
    public void addBook(Book book) {
        books.add(book);
        numBooks++;
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
        numMovies++;
    }
    public void removeBook(String book) {
        List<Book> temp = new ArrayList<>(books);
        int index = 0;
        for (int i = 0; i < numBooks; i++) {
            if (books.get(i).equals(book)) {
                books.set(i, null);
                for (int j = 0; j < numBooks; j++) {
                    if (books.get(j) != null) {
                        temp.set(index,books.get(j));
                    }
                    index++;
                    numBooks--;
                }
            }
        }
        books = temp;
    }
    public void removeMovie(String movie) {
        List<Movie> temp = new ArrayList<>(movies);
        int index = 0;
        for (int i = 0; i < numMovies; i++) {
            if (movies.get(i).equals(movie)) {
                movies.set(i, null);
                for (int j = 0; j < numMovies; j++) {
                    if (movies.get(j) != null) {
                        temp.set(index, movies.get(j));
                    }
                    index++;
                    numMovies--;
                }
            }
        }
        movies = temp;
    }
    public void checkoutBook(Book book) {
        if(numBooks > 0) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).equals(book)) {
                    checkedOutBooks.add(book);
                    books.remove(book);
                    numBooks--;
                    break;
                } else if(i == books.size() - 1) {
                    System.out.println("Book Not Available");
                }
            }
        }
    }
    public void checkoutMovie(Movie movie) {
        if(numMovies > 0) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).equals(movie)) {
                    checkedOutMovies.add(movie);
                    movies.remove(movie);
                    numMovies--;
                    break;
                }else if(i==movies.size()-1){
                    System.out.println("Movie Not Available");
                }
            }
        }
    }
    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        books.add(book);
        numBooks++;
    }
    public void returnMovie(Movie movie) {
        checkedOutMovies.remove(movie);
        movies.add(movie);
        numMovies++;
    }
    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
    public List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }
}
