import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] array = new long[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextLong();
        }

        sortByBytes(array);

        StringBuilder result = new StringBuilder();
        for (long num : array) {
            result.append(num).append("\n");
        }
        System.out.print(result);
    }

    private static void sortByBytes(long[] array) {
        final int BYTES = 8; // Количество байтов в long
        final int RANGE = 256; // Количество возможных значений байта
        long[] temp = new long[array.length];
        long[] count = new long[RANGE];

        for (int byteIndex = 0; byteIndex < BYTES; byteIndex++) {
            for (int i = 0; i < RANGE; i++) {
                count[i] = 0;
            }

            // количество каждого байта
            for (int i = 0; i < array.length; i++) {
                int byteValue = (int) ((array[i] >> (byteIndex * 8)) & 0xFF);
                count[byteValue]++;
            }

            // позиции для каждого байта
            for (int i = 1; i < RANGE; i++) {
                count[i] += count[i - 1];
            }

            // числа по позициям
            for (int i = array.length - 1; i >= 0; i--) {
                int byteValue = (int) ((array[i] >> (byteIndex * 8)) & 0xFF);
                temp[(int) (--count[byteValue])] = array[i];
            }

            System.arraycopy(temp, 0, array, 0, array.length);
        }
    }
}
