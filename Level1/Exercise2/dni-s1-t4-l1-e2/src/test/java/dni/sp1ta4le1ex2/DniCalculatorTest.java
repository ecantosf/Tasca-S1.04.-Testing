package dni.sp1ta4le1ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dni.sp1ta4le1ex2.DniCalculator.calculateLetter;
import static org.junit.jupiter.api.Assertions.*;

public class DniCalculatorTest {

    @Test
    @DisplayName("Unit test: Test with a verified DNI")
    // Data from: https://generador-de-dni.es/dni/
    void unitariTest(){
        char result = calculateLetter(48235794);
        assertEquals('X',result);
    }

    @ParameterizedTest
    @CsvSource({
            "48235794,X",
            "29073668,N",
            "22195059,J",
            "63269406,V",
            "40498812,K",
            "74407433,H",
            "55910781,N",
            "31178395,D",
            "77824730,K",
            "13947898,P"
    })
    @DisplayName("Parameterized test: Valid DNIs previously verified")
    void tenDifferentDniTest(int dni, char expected){
        assertEquals(expected,calculateLetter(dni));
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "100000000",
            "999999999"
    })
    @DisplayName("Parameterized test: Invalid DNIs throw exception")
    void parametrizedTestInvalidDnis(int dniInvalid) {

        assertThrows(IllegalArgumentException.class, () -> {
            DniCalculator.calculateLetter(dniInvalid);
        });
    }

}
