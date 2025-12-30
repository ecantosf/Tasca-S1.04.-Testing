package assertj.sp1ta4le2ex6;

public class OutOfBounds {

    public int accessArrayWithIndex(int index) throws ArrayIndexOutOfBoundsException {
        int[] array = {1, 2, 3, 4, 5};

        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Índex " + index + " fora dels límits. Array té mida " + array.length
            );
        }

        return array[index];
    }
}
