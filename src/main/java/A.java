import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

    // нахождение НОД
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // приведение дроби к несократимой форме
    private static int[] minimize(int numerator, int denominator) {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int divider = gcd(Math.abs(numerator), denominator);
        return new int[]{numerator / divider, denominator / divider};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        //дроби
        List<int[]> fractions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            // записываем все дроби в сокращенной форме
            fractions.add(minimize(numerator, denominator));
        }

        // сортируем
        fractions.sort((a, b) -> {
            //приводим к общему знаменателю и сравниваем
            long first = (long) a[0] * b[1];
            long second = (long) b[0] * a[1];
            //сравниваем числители, тк знаменатели равны
            return Long.compare(first, second);
        });

        // вывод
        fractions.forEach(fraction -> System.out.println(fraction[0] + " " + fraction[1]));
    }
}
