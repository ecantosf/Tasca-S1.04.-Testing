package exception.sp1ta4le1ex3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayExceptionGeneratorTest {

    @Test
    @DisplayName("Test that verifies the exception with accessArray")
    void testAccessArrayThrowsException() {
        int[] array = {1, 2, 3};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ArrayExceptionGenerator.accessArray(array, 5);
        });
    }

    @Test
    @DisplayName("Test that verifies NO exception is thrown with a valid index")
    void testAccessArrayValidIndex() {
        int[] array = {10, 20, 30};

        int result = assertDoesNotThrow(() -> {
            return ArrayExceptionGenerator.accessArray(array, 1);
        });

        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test with generateException (simplified version)")
    void testGenerateExceptionMethod() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ArrayExceptionGenerator.generateException(3, -1);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ArrayExceptionGenerator.generateException(5, 5);
        });
    }

    @Test
    @DisplayName("\"Parameterized test")
    void testMultipleInvalidIndices() {
        int[] invalidIndices = {-10, -1, 3, 10};
        int[] array = {1, 2, 3};

        for (int index : invalidIndices) {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                ArrayExceptionGenerator.accessArray(array, index);
            }, "Should throw exception for index: " + index);
        }
    }
}
