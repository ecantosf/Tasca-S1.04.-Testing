package library.sp1ta4le1ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Error: Title cannot be empty.");
            return;
        }
        Book book = new Book(title);
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("\nAll books in library:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.getTitle());
        }
    }

    public Book getBookAtPosition(int position) {
        if (position < 0 || position >= books.size()) {
            return null;
        }
        return books.get(position);
    }

    public Book getBookByPositionManual(int position) {
        if (position < 1 || position > books.size()) {
            throw new IllegalArgumentException("Invalid position. Valid positions: 1 to " + books.size());
        }
        return books.get(position - 1);
    }

    public void getBookByPosition(Scanner scanner) {
        System.out.print("Enter position (starting from 1): ");
        int position = scanner.nextInt();
        scanner.nextLine();

        try {
            Book book = getBookByPositionManual(position);
            System.out.println("Book at position " + position + ": " + book.getTitle());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean addBookAtPosition(String title, int position) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }

        if (position < 1 || position > books.size() + 1) {
            return false;
        }

        Book book = new Book(title.trim());
        books.add(position - 1, book);
        return true;
    }

    public void addBookAtPosition(Scanner scanner) { // Eliminat Library library com a paràmetre
        System.out.print("Enter position: ");
        int position = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Error: El títol no pot estar buit.");
            return;
        }

        if (position < 1 || position > books.size() + 1) {
            System.out.println("Error: Invalid position. Valid positions: 1 to " + (books.size() + 1));
            return;
        }

        Book book = new Book(title);
        books.add(position - 1, book);
        System.out.println("Book '" + title + "' added at position " + position);
    }

    public boolean removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public void removeBookByTitle(Scanner scanner) {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine().trim();

        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                removed = true;
                System.out.println("Book '" + title + "' removed successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Book '" + title + "' not found in the library.");
        }
    }

    public void showSortedBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nBooks in alphabetical order:");
        for (int i = 0; i < sortedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + sortedBooks.get(i).getTitle());
        }
    }

    public int getBookCount() {
        return books.size();
    }
}
