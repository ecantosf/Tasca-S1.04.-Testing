package library.sp1ta4le1ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Error: El títol no pot estar buit.");
            return;
        }

        Book book = new Book(title);
        books.add(book);;

        System.out.println("\nBook '" + title + "' added properly.");
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

    public void getBookByPosition(Scanner scanner) {
        System.out.print("Enter position (starting from 1): ");
        int position = scanner.nextInt();
        scanner.nextLine();

        if (position < 1 || position > books.size()) {
            System.out.println("Error: Invalid position. Valid positions: 1 to " + books.size());
            return;
        }

        Book book = books.get(position - 1);
        System.out.println("Book at position " + position + ": " + book.getTitle());
    }

    public void addBookAtPosition(Scanner scanner) {
        System.out.print("Enter position (starting from 1): ");
        int position = scanner.nextInt();
        scanner.nextLine(); // Netejar buffer

        if (position < 1 || position > books.size() + 1) {
            System.out.println("Error: Invalid position. Valid positions: 1 to " + (books.size() + 1));
            return;
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Error: El títol no pot estar buit.");
            return;
        }

        Book book = new Book(title);
        books.add(position - 1, book);
        System.out.println("\nLlibre '" + title + "' afegit a la posició " + position + " correctament.");
    }

    public void removeBookByTitle(Scanner scanner) {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine().trim();

        boolean removed = false;
        // Cerca i elimina el llibre
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

        // Crear una còpia de la llista per ordenar
        List<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        System.out.println("\n--- BOOKS IN ALPHABETICAL ORDER ---");
        for (int i = 0; i < sortedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + sortedBooks.get(i).getTitle());
        }
    }

    // Mètode per obtenir el nombre de llibres (opcional)
    public int getBookCount() {
        return books.size();
    }

}
