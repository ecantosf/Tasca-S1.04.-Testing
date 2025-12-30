package assertj.sp1ta4le2ex7Test;

import assertj.sp1ta4le2ex7.MyOptional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyOptionalTest {

    @Test
    @DisplayName("Optional Empty")
    public void testEmptyOptionalCreation() {
        MyOptional<String> emptyOptional = MyOptional.empty();

        assertTrue(emptyOptional.isEmpty(),
                "Optional created with empty() must return true for isEmpty()");

        assertFalse(emptyOptional.isPresent(),
                "Optional created with empty() must return false for isPresent()");

        assertThrows(Exception.class, emptyOptional::get,
                "get() on an empty Optional must throw an exception");
    }

}
