package assertj.sp1ta4le2ex2Test;

import assertj.sp1ta4le2ex2.Reference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReferenceTest {

    @Test
    @DisplayName("Same Reference")
    public void testSameReference() {
        Reference ref1 = new Reference(1, "Test");
        Reference ref2 = ref1;

        assertThat(ref1).isSameAs(ref2);
    }

    @Test
    @DisplayName("Different Reference")
    public void testDifferentReferences() {
        Reference ref1 = new Reference(1, "Test");
        Reference ref2 = new Reference(1, "Test");

        assertThat(ref1)
                .isNotSameAs(ref2)
                .isEqualTo(ref2);

        assertThat(ref1)
                .as("Verify different references with the same content")
                .isNotSameAs(ref2)
                .isEqualTo(ref2);
    }
}
