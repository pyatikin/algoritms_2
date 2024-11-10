import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    
    static class Sections implements Comparable<Sections> {
        int x1, y1, x2, y2;
        double area;

        Sections(int x1, int y1, int x2, int y2, int xBase, int yBase) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.area = area(xBase, yBase);
        }

        @Override
        public int compareTo(Sections other) {
            return Double.compare(this.area, other.area);
        }

        private void print() {
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        }

        private double area(int xBase, int yBase) {
            return 0.5 * Math.abs(xBase * (y1 - y2) + x1 * (y2 - yBase) + x2 * (yBase - y1));

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Sections> sections = new ArrayList<>();

        // ввод опорной точки
        int xBase = scanner.nextInt();
        int yBase = scanner.nextInt();

        int N = scanner.nextInt();

        // ввод отрезков и расчет площади треугольника
        for (int i = 0; i < N; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            sections.add(new Sections(x1, y1, x2, y2, xBase, yBase));
        }

        // сортировка
        Collections.sort(sections);

        // вывод
        sections.forEach(Sections::print);
    }
}
