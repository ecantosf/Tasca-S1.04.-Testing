package assertj.sp1ta4le2ex3Test;

import assertj.sp1ta4le2ex3.TwoIdentical;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoIdenticalTest {

    @Test
    @DisplayName("Two Identical Arrays")
    void testIdenticalArrays() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};

        assertArrayEquals(array1, array2);
    }

    @Test
    @DisplayName("Two Different Arrays")
    void testDifferentArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 4};

        assertFalse(java.util.Arrays.equals(array1, array2));
    }

}
