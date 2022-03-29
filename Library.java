import java.util.ArrayList;
import Book.java;

public class Library {
    // Add the missing implementation to this class
    private String address;
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public Library() {
       
    }

    public Library(String address) {
        this.address = address;
    }
    public void addBook(Book book) {
        bookList.add(book);
        
    }

    public void printAddress() {
        System.out.println("This library is at " + this.address);
    }

    static void printOpeningHours() {
        System.out.println("This hours are 9AM to 5PM");
    }

    public void borrowBook(String name) {
    boolean here = false; 
     for (Book book:bookList) { 
         String bname = book.getTitle();
        if (bname.equals(name)) { 
            here = true;
            if (!book.isBorrowed()){
                System.out.println("You have successfully borrowed " + bname);
                book.borrowed();
         } 
            else {System.out.println("Sorry, this book is already borrowed.");}
        }
        }if (!here) {System.out.println("Sorry this book is not in our catalog.");}
    }
    public void printAvailableBooks() {
        if (bookList.size() == 0) {
            System.out.println("No books in catalog");
        }else {
            for (Book book: bookList) {
                //System.out.println(book.isBorrowed());
                if (!book.isBorrowed()){ System.out.println(book.getTitle());}
            }
        }
    }

    public void returnBook(String title) {
        for (Book book:bookList) { 
            String bname = book.getTitle();
           if (bname.equals(title)) { 
             book.returned();
             System.out.println("You successfully returned " + title);
           }
       //does not account for other cases
        }
    }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}