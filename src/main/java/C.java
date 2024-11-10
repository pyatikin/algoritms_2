import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
        static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }

        private void print() {
            System.out.println(start + " " + end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        // сортируем по началу
        Collections.sort(intervals);

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i < N; i++) {
            Interval next = intervals.get(i);
            if (next.start <= current.end) {
                // объединяем
                current.end = Math.max(current.end, next.end);
            } else {
                // добавление в итоговые отрезки
                mergedIntervals.add(current);
                current = next;
            }
        }

        // последний отрезок
        mergedIntervals.add(current);

        // вывод
        System.out.println(mergedIntervals.size());
        mergedIntervals.forEach(Interval::print);

        // конец
    }
}
