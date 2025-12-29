package library.sp1ta4le1ex1;

import java.util.Scanner;

public class Main {
    private static void showMenu() {
        System.out.println("\nLibrary Management:");
        System.out.println("1. Add book (at the end)");
        System.out.println("2. Show all books");
        System.out.println("3. Search book by position");
        System.out.println("4. Add book at specific position");
        System.out.println("5. Delete book by title");
        System.out.println("6. Show books in alphabetical order");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    library.getBookByPosition(scanner);
                    break;
                case 4:
                    library.addBookAtPosition(scanner); // Corregit: sense segon paràmetre
                    break;
                case 5:
                    library.removeBookByTitle(scanner);
                    break;
                case 6:
                    library.showSortedBooks();
                    break;
                case 7: // Canviat de 0 a 7 per coincidir amb el menú
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Wrong choice.");
            }
        } while (choice != 7); // Canviat de 0 a 7

        scanner.close();
    }
}