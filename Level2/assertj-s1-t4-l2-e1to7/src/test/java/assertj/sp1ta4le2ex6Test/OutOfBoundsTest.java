package assertj.sp1ta4le2ex6Test;

import assertj.sp1ta4le2ex6.OutOfBounds;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundsTest {

    private final OutOfBounds outOfBounds = new OutOfBounds();

    @Test
    @DisplayName("Negative Index Throws Exception")
    void testNegativeIndexThrowsException() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> outOfBounds.accessArrayWithIndex(-1),
                "Should throw exception with index 5"
        );
    }

    @Test
    @DisplayName("Index Too Large Throws Exception")
    void testIndexTooLargeThrowsException() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> outOfBounds.accessArrayWithIndex(5),
                "Hauria de llançar excepció amb índex 5"
        );

        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> outOfBounds.accessArrayWithIndex(10),
                "Should throw exception with index 10"
        );
    }
}