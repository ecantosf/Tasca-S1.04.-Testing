package library.sp1ta4le1ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Test 1: Null List")
    void testNullList() {
        Library libraryNull = null;
        assertNull(libraryNull, "List should be null");
    }

    @Test
    void testLibraryInitiallyEmpty() {
        assertEquals(0, library.getBookCount(),
                "Library should be empty initially");
    }

    @Test
    @DisplayName("Test 2: Add 4 books")
    void testAddFourBooks() {
        library.addBook(new Book("La plaça del diamant"));
        library.addBook(new Book("Tirant lo Blanc"));
        library.addBook(new Book("Terra Baixa"));
        library.addBook(new Book("El mirall"));

        assertEquals(4, library.getBookCount(),
                "After adding 4 books, size should be 4");
    }

    @Test
    @DisplayName("Test 3: Simple position verification")
    void testBooksPositions() {
        library.addBook(new Book("El ingenioso hidalgo don Quijote de la Mancha"));
        library.addBook(new Book("Cien años de soledad "));
        library.addBook(new Book("La ciudad de los prodigios"));

        assertEquals("El ingenioso hidalgo don Quijote de la Mancha", library.getBookAtPosition(0).getTitle());
        assertEquals("Cien años de soledad ", library.getBookAtPosition(1).getTitle());
        assertEquals("La ciudad de los prodigios", library.getBookAtPosition(2).getTitle());
    }

    @Test
    @DisplayName("Test 4: Get book by position - valid positions")
    void testGetBookByPositionManual() {
        library.addBook(new Book("El ingenioso hidalgo don Quijote de la Mancha"));
        library.addBook(new Book("Cien años de soledad"));
        library.addBook(new Book("La ciudad de los prodigios"));

        Book book1 = library.getBookByPositionManual(1);
        assertEquals("El ingenioso hidalgo don Quijote de la Mancha", book1.getTitle());

        Book book2 = library.getBookByPositionManual(2);
        assertEquals("Cien años de soledad", book2.getTitle());

        Book book3 = library.getBookByPositionManual(3);
        assertEquals("La ciudad de los prodigios", book3.getTitle());
    }

    @Test
    @DisplayName("Test 5.1: Add book at first position")
    void testAddBookAtFirstPosition() {
        library.addBook(new Book("Llibre Existente"));

        boolean result = library.addBookAtPosition("Primer Llibre", 1);

        assertTrue(result);
        assertEquals(2, library.getBookCount());
        assertEquals("Primer Llibre", library.getBookAtPosition(0).getTitle());
        assertEquals("Llibre Existente", library.getBookAtPosition(1).getTitle());
    }

    @Test
    @DisplayName("Test 5.2: Add book at last position")
    void testAddBookAtLastPosition() {
        // Arrange
        library.addBook(new Book("Llibre 1"));
        library.addBook(new Book("Llibre 2"));

        boolean result = library.addBookAtPosition("Últim Llibre", 3);

        assertTrue(result);
        assertEquals(3, library.getBookCount());
        assertEquals("Últim Llibre", library.getBookAtPosition(2).getTitle());
    }

    @Test
    @DisplayName("Test 5.3: Add book at invalid position (too high)")
    void testAddBookAtInvalidHighPosition() {
        // Arrange
        library.addBook(new Book("Llibre 1"));

        boolean result = library.addBookAtPosition("Nou Llibre", 3);

        assertFalse(result, "Should return false for position > size + 1");
        assertEquals(1, library.getBookCount(), "Should not add book");
    }

    @Test
    @DisplayName("Test 6: Remove book by title reduces collection size")
    void testRemoveBookByTitleReducesSize() {
        // Afegir llibres
        library.addBook(new Book("La plaça del diamant"));
        library.addBook(new Book("Tirant lo Blanc"));
        library.addBook(new Book("Terra Baixa"));

        assertEquals(3, library.getBookCount(), "Initial size should be 3");

        boolean removed = library.removeBookByTitle("Tirant lo Blanc");

        assertTrue(removed, "Book should be removed successfully");
        assertEquals(2, library.getBookCount(),
                "After removing one book, size should be 2");
    }


    @Test
    @DisplayName("Test 7: Sorting output")
    void testShowSortedBooksOutput() {
        // Afegir llibres
        library.addBook(new Book("Tirant lo Blanc"));
        library.addBook(new Book("La plaça del diamant"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.showSortedBooks();

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("La plaça del diamant"));
        assertTrue(output.contains("Tirant lo Blanc"));
    }

    @Test
    @DisplayName("Test 8: Duplicate titles ARE allowed (testing opposite behavior)")
    void testDuplicateTitlesAllowed() {
        library.addBook(new Book("The Lord of the Rings"));
        assertEquals(1, library.getBookCount(), "First book added correctly");

        library.addBook(new Book("The Lord of the Rings"));

        assertEquals(2, library.getBookCount(),
                "A book with a duplicate title SHOULD be added in this implementation");
    }

}
