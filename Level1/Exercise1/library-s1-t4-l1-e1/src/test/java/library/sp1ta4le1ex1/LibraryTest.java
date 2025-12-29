package library.sp1ta4le1ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    @DisplayName("Test 1: Null List")
    void ListNullTest() {
        Library libraryNull = new Library();
        libraryNull = null;
        assertNull(libraryNull);
    }

    /*@Test
    void testLibraryCreation() {
        // Given - When
        Library library = new Library();
        // Then
        assertNotNull(library, "The Library instance must not be null");
        assertEquals(0, library.getBookCount(),
                "A new library should be empty");
    }*/

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
