package dni.sp1ta4le1ex2;

public class DniCalculator {

    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char calculateLetter(int numberDNI) {
        char letterResu;
        if (numberDNI < 0 || numberDNI > 99999999) {
            throw new IllegalArgumentException("Invalid DNI number: " + numberDNI);
        }
            int remainder = numberDNI % 23;
            return DNI_LETTERS.charAt(remainder);
    }
}
