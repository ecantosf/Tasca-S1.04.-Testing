package library.sp1ta4le1ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();  // Nova instància per a cada test
    }

    @Test
    @DisplayName("Test 1: Null List")
    void testNullList() {
        Library libraryNull = null;
        assertNull(libraryNull, "La llista hauria de ser null");
    }

    @Test
    void testLibraryInitiallyEmpty() {
        assertEquals(0, library.getBookCount(),
                "La biblioteca hauria d'estar buida inicialment");
    }

    @Test
    @DisplayName("Test 2: Add 4 books")
    void testAddFourBooks() {
        // Comprovar que després d'afegir 4 llibres, la mida és 4
        library.addBook(new Book("La plaça del diamant"));
        library.addBook(new Book("Tirant lo Blanc"));
        library.addBook(new Book("Terra Baixa"));
        library.addBook(new Book("El mirall"));

        assertEquals(4, library.getBookCount(),
                "Després d'afegir 4 llibres, la mida hauria de ser 4");
    }

    /*@Test
    void getNegativeTest() {
        Library library = new Library();
        String result = library.getName(-1);
        Assertions.assertEquals("negatiu", result);
    }

    @Test
    void getPositiveTest() {
        Library library = new Library();
        String result = library.getName(1);
        Assertions.assertEquals("positiu", result);
    }

    @Test
    void getZeroTest() {
        Library library = new Library();
        String result = library.getName(0);
        Assertions.assertEquals("positiu", result);
    }

    @Test
    void givenTwoNumber_whenAdd_thenGetRightAdd() {
        // Given (Arranjament)
        int a = 2;
        int b = 3;

        // When (Acció)
        int result = a + b;

        // Then (Afirmació)
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Suma més guai!")
    void addingPositiveTest() {
        // Given (Arranjament)
        int a = 6;
        int b = 3;

        // When (Acció)
        int resultat = Library.suma(a, b);

        // Then (Verificació)
        assertEquals(9, resultat);
    }

    @Test
    void testDivideixPerZero() {
        assertThrows(ArithmeticException.class, () -> {
            Library.divideix(10, 0);
        });
    }

    @Test
    @DisplayName("Test 'Null'")
    void nullTest() {
        // Given and Whan
        String result = null;

        // Then (Afirmació)
        assertNull(result);
    }*/

}
