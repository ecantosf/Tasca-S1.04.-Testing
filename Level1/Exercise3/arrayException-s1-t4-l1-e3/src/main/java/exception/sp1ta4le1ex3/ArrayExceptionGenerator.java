package exception.sp1ta4le1ex3;

public class ArrayExceptionGenerator {
    public static int accessArray(int[] array, int index) {
        return array[index];
    }

    public static int generateException(int size, int index) {
        int[] array = new int[size];
        return array[index];
    }
}
