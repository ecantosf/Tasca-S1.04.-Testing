package assertj.sp1ta4le2ex1Test;

import assertj.sp1ta4le2ex1.TwoObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TwoObjectsTest {

    @Test
    @DisplayName("Two Objects With Same Value Are Equals")
    public void testTwoObjectsWithSameValueAreEqual() {
        TwoObjects obj1 = new TwoObjects(10);
        TwoObjects obj2 = new TwoObjects(10);

        assertThat(obj1).isEqualTo(obj2);
    }

    @Test
    @DisplayName("Two Objects With Different Value Are Not Equals")
    public void testTwoObjectsWithDifferentValuesAreNotEqual() {
        TwoObjects obj1 = new TwoObjects(10);
        TwoObjects obj2 = new TwoObjects(20);

        assertThat(obj1).isNotEqualTo(obj2);
    }
}
