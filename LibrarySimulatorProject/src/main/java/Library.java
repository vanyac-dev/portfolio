import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
    static Scanner scanner = new Scanner(System.in);
    static LibraryInterface lib = new LibraryInterface();
    //public Library(){}
    public static void main(String[] args) {
        System.out.println("Welcome to Library Simulator");
        System.out.println("Would you like to setup a custom library (enter 'c') or begin simulation with the default library (enter 'd')?");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("c")){
            System.out.println("Please enter the name of your library:");
            String libraryName = scanner.nextLine();
            LibraryInterface lib = new LibraryInterface(libraryName);
            System.out.println("Wonderful! " + libraryName + " has been created and is ready for its first books/movies.");
            System.out.println("Would you like to create simple books/movies with 2 inputs (enter 's') or expansive books/movies with 5 inputs (enter 'e')?");
            input = scanner.nextLine();
            if(!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("e")) {
                while(!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("e")) {
                    System.out.println("Invalid input. Please try again.");
                    input = scanner.nextLine();
                }
            }
            if(input.equalsIgnoreCase("s")){
                //simple books/movies
                input = "w";
                while(!input.equals("n")) {
                    input = bookOrMovie();
                    while (input == null) {
                        System.out.println("Please enter a valid input");
                        //asks if user wants to make a book or movie to add to library
                        input = bookOrMovie();
                    }
                    if (input.equals("b")) {
                        System.out.println("Please enter title of book: ");
                        String title = scanner.nextLine();
                        System.out.println("Please enter author: ");
                        String author = scanner.nextLine();
                        Book book = new Book(title, author);
                        lib.addBook(book);
                        System.out.println(title + " by " + author + " has been created and added to library.");
                        input = addAnother(input);
                        if (input.equalsIgnoreCase("n")) {
                            break;
                        }
                    } else {
                        System.out.println("Please enter title of movie: ");
                        String title = scanner.nextLine();
                        System.out.println("Please enter director: ");
                        String director = scanner.nextLine();
                        Movie movie = new Movie(title, director);
                        lib.addMovie(movie);
                        System.out.println(title + " by " + director + " has been created and added to library.");
                        //asks if user wants to add another book or movie
                        input = addAnother(input);
                        if (input.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                }
            }else if(input.equalsIgnoreCase("e")){
                //expansive books/movies
                input = "w";
                while(!input.equals("n")) {
                    //asks if user wants to make a book or movie to add to library
                    input = bookOrMovie();
                    if (input.equalsIgnoreCase("b")) {
                        System.out.println("Please enter title of book: ");
                        String title = scanner.nextLine();
                        System.out.println("Please enter author: ");
                        String author = scanner.nextLine();
                        System.out.println("Please enter publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.println("Please enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.println("Please enter the number of pages (e.g. 110): ");
                        boolean isInteger = false;
                        int numberOfPages = -1;
                        while(!isInteger) {
                            try {
                                numberOfPages = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                isInteger = false;
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        Book book = new Book(title, author, publisher, genre, numberOfPages);
                        lib.addBook(book);
                        System.out.println(title + " by " + author + " has been created and added to library.");
                        System.out.println("Genre: " + genre + " | Publisher: " + publisher + " | Pages: " + numberOfPages);
                        //asks if user wants to add another book or movie
                        input = addAnother(input);
                        if (input.equalsIgnoreCase("n")) {
                            break;
                        }
                    } else if (input.equalsIgnoreCase("m")) {
                        System.out.println("Please enter title of movie: ");
                        String title = scanner.nextLine();
                        System.out.println("Please enter director: ");
                        String director = scanner.nextLine();
                        System.out.println("Please enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.println("Please enter year released (e.g. 2012): ");
                        boolean isInteger = false;
                        int yearReleased = -1;
                        while(!isInteger) {
                            try {
                                yearReleased = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                isInteger = false;
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        System.out.println("Please enter the movie duration in minutes: ");
                        int movieDuration = -1;
                        isInteger = false;
                        while(!isInteger) {
                            try {
                                movieDuration = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                isInteger = false;
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        Movie movie = new Movie(title, director, genre, yearReleased, movieDuration);
                        lib.addMovie(movie);
                        System.out.println(title + " (" + yearReleased + ") by " + director + " has been created and added to library.");
                        System.out.println("Genre: " + genre + " | Duration: " + movieDuration + " minutes");
                        //asks if user wants to add another book or movie
                        input = addAnother(input);
                        if (input.equalsIgnoreCase("n")) {
                            break;
                        }
                    }

                }
            }

            System.out.println("Great! " + libraryName + " has " + lib.getNumBooks() + " books and " + lib.getNumMovies() + " movies.");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to " + lib.getLibraryName() + " Library");
            System.out.println("My name is Alice and I will be your librarian today. How may I help you?");
            boolean quitCheck = true;
            while(quitCheck) {
                System.out.println("You can...");
                System.out.println("(a) Borrow a book \n (b) Return a book \n (c) Borrow a movie \n (d) Return a movie \n (q) To quit \n Please select an option.");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("d") && !input.equalsIgnoreCase("q")) {
                    System.out.println("Please enter a valid input");
                    if (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("d") && !input.equalsIgnoreCase("q")) {
                        input = scanner.nextLine();
                    }
                }
                if (input.equalsIgnoreCase("q")) {
                    quitCheck = false;
                    System.out.println("Thank you for using Library Simulator.");
                    System.out.println("Goodbye!");
                    //System.exit(0);
                } else if (input.equalsIgnoreCase("a")) {
                    if (lib.getBooks().size() == 0) {
                        System.out.println("No books in stock. To borrow a book again, please return a book.");
                    } else {
                        System.out.println("Books in Stock: \n" + lib.getBooksToString());
                        System.out.println("Please enter the title of the book you would like to borrow: ");
                        input = scanner.nextLine().trim();
                        List<Book> list = lib.getBooks();
                        boolean found = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been borrowed.");
                                lib.checkoutBook(list.get(i));
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Invalid input, book not found. Please try again.");
                        }
                    }

                } else if (input.equalsIgnoreCase("b")) {
                    if (lib.getCheckedOutBooks().isEmpty()) {
                        System.out.println("No books have been checked out of " + lib.getLibraryName() + ". No book returns necessary.");
                    } else {
                        System.out.println("Which book would you like to return? Please enter the title: ");
                        input = scanner.nextLine().trim();
                        List<Book> list = lib.getCheckedOutBooks();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been returned.");
                                lib.returnBook(list.get(i));
                            } else if (i == list.size() - 1) {
                                System.out.println("Invalid input, book not found. Please try again.");
                            }
                        }
                    }
                } else if (input.equalsIgnoreCase("c")) {
                    if (lib.getBooks().isEmpty()) {
                        System.out.println("No movies in stock. To borrow a movie again, please return a movie.");
                    } else {
                        System.out.println("Movies in Stock: \n" + lib.getMoviesToString());
                        System.out.println("Please enter the title of the movie you would like to borrow: ");
                        input = scanner.nextLine().trim();
                        List<Movie> list = lib.getMovies();
                        boolean found = false;
                        for (int i = 0; i < list.size(); i++) {
                            String s = list.get(i).getTitle().trim();
                            if (s.equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been borrowed.");
                                lib.checkoutMovie(list.get(i));
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("Invalid input, book not found. Please try again.");
                        }
                    }
                } else if (input.equalsIgnoreCase("d")) {
                    if (lib.getCheckedOutMovies().isEmpty()) {
                        System.out.println("No movies have been checked out of " + lib.getLibraryName() + ". No movie returns necessary.");
                    } else {
                        System.out.println("Which movie would you like to return? Please enter the title: ");
                        input = scanner.nextLine().trim();
                        List<Movie> list = lib.getCheckedOutMovies();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been returned.");
                                lib.returnMovie(list.get(i));
                            } else if (i == list.size() - 1) {
                                System.out.println("Invalid input, movie not found. Please try again.");
                            }
                        }
                    }
                }
            }

        }else if(input.equalsIgnoreCase("d")){
            LibraryInterface lib = new LibraryInterface();
            System.out.println("Welcome to " + lib.getLibraryName() + " Library");
            System.out.println("My name is Alice and I will be your librarian today. How may I help you?");
            boolean quitCheck = true;
            while(quitCheck) {
                System.out.println("You can...");
                System.out.println("(a) Borrow a book \n (b) Return a book \n (c) Borrow a movie \n (d) Return a movie \n (q) To quit \n Please select an option.");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("d") && !input.equalsIgnoreCase("q")) {
                    System.out.println("Please enter a valid input");
                    if (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("d") && !input.equalsIgnoreCase("q")) {
                        input = scanner.nextLine();
                    }
                }
                if (input.equalsIgnoreCase("q")) {
                    quitCheck = false;
                    System.out.println("Thank you for using Library Simulator.");
                    System.out.println("Goodbye!");
                    //System.exit(0);
                } else if (input.equalsIgnoreCase("a")) {
                    if(lib.getNumBooks() == 0){
                        System.out.println("No books in stock. To borrow a book again, please return a book.");
                    }else {
                        System.out.println("Books in Stock: \n" + lib.getBooksToString());
                        System.out.println("Please enter the title of the book you would like to borrow: ");
                        input = scanner.nextLine().trim();
                        List<Book> list = lib.getBooks();
                        boolean found = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been borrowed.");
                                lib.checkoutBook(list.get(i));
                                found = true;
                            } /*else if (i == list.size() - 1) {
                                System.out.println("Invalid input, book not found. Please try again.");
                            }*/
                        }
                        if(!found){
                            System.out.println("Invalid input, book not found. Please try again.");
                        }
                    }
                } else if (input.equalsIgnoreCase("b")) {
                    if(lib.getNumBooks()==0){
                        System.out.println("No books have been checked out of " + lib.getLibraryName() + ". No book returns necessary.");
                    }else {
                        System.out.println("Which book would you like to return? Please enter the title: ");
                        input = scanner.nextLine().trim();
                        List<Book> list = lib.getCheckedOutBooks();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been returned.");
                                lib.returnBook(list.get(i));
                            } else if (i == list.size() - 1) {
                                System.out.println("Invalid input, book not found. Please try again.");
                            }
                        }
                    }
                } else if (input.equalsIgnoreCase("c")) {
                    if(lib.getNumMovies()==0){
                        System.out.println("No movies in stock. To borrow a movie again, please return a movie.");
                    }else {
                        System.out.println("Movies in Stock: \n" + lib.getMoviesToString());
                        System.out.println("Please enter the title of the movie you would like to borrow: ");
                        input = scanner.nextLine().trim();
                        List<Movie> list = lib.getMovies();
                        boolean found = false;
                        for (int i = 0; i < list.size(); i++) {
                            String s = list.get(i).getTitle().trim();
                            if (s.equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been borrowed.");
                                lib.checkoutMovie(list.get(i));
                                found = true;
                            } /*else if (i == list.size() - 1) {
                                System.out.println("Invalid input, movie not found. Please try again.");
                            }*/
                        }
                        if(!found){
                            System.out.println("Invalid input, book not found. Please try again.");
                        }
                    }
                } else if (input.equalsIgnoreCase("d")) {
                    if(lib.getCheckedOutMovies().size()==0){
                        System.out.println("No movies have been checked out of " + lib.getLibraryName() + ". No movie returns necessary.");
                    }else {
                        System.out.println("Which movie would you like to return? Please enter the title: ");
                        input = scanner.nextLine().trim();
                        List<Movie> list = lib.getCheckedOutMovies();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTitle().trim().equalsIgnoreCase(input)) {
                                System.out.println(list.get(i).getTitle() + " has been returned.");
                                lib.returnMovie(list.get(i));
                            } else if (i == list.size() - 1) {
                                System.out.println("Invalid input, movie not found. Please try again.");
                            }
                        }
                    }
                }
            }

        }else{
            System.out.println("Please enter a valid input and try again");
        }
    }
    public static String bookOrMovie(){
        boolean correctInput = false;
        while(!correctInput) {
            System.out.println("Would you like to create a book (enter 'b') or a movie (enter 'm')?");
            String bOrM = scanner.nextLine();
            if (bOrM.equalsIgnoreCase("b")) {
                return "b";
            } else if (bOrM.equalsIgnoreCase("m")) {
                return "m";
            } else {
                System.out.println("Please enter a valid input and try again");
            }
        }
        return "b";
    }
    public static String addAnother(String input){
        System.out.println("Would you like to add another book or movie? (y/n)");
        boolean correctInput = false;
        input = scanner.nextLine();
        while(!correctInput) {
            if(input==null || input.equalsIgnoreCase("\n") || input.equalsIgnoreCase("") || input.equalsIgnoreCase(" ")) {
                input = scanner.nextLine();
            }
            if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                input = null;
                System.out.println("Please enter a valid input");
            }else if (input.equalsIgnoreCase("y")||input.equalsIgnoreCase("n")) {
                correctInput = true;
            }
        }
        return input;
    }
}

