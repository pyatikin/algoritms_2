import java.util.*;

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

        // Сортировка отрезков по началу
        Collections.sort(intervals);

        // Объединение отрезков
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i < N; i++) {
            Interval next = intervals.get(i);
            if (next.start <= current.end) {
                // Объединяем отрезки
                current.end = Math.max(current.end, next.end);
            } else {
                // Добавляем текущий отрезок в список объединенных отрезков
                mergedIntervals.add(current);
                current = next;
            }
        }

        // Добавляем последний отрезок
        mergedIntervals.add(current);

        // Вывод объединенных отрезков
        System.out.println(mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
