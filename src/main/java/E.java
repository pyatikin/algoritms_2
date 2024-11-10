import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class E {

    static class Element implements Comparable<Element> {
        int value;
        int arrayIndex;
        int elementIndex;

        Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        int[][] arrays = new int[K][];
        int[] sizes = new int[K];

        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(reader.readLine());
            sizes[i] = N;
            arrays[i] = new int[N];
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arrays[i][j] = Integer.parseInt(line[j]);
            }
        }

        // приоритетная куча
        PriorityQueue<Element> heap = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            if (sizes[i] > 0) {
                heap.add(new Element(arrays[i][0], i, 0));
            }
        }

        StringBuilder result = new StringBuilder();

        // берем минимальный элемент из всех массивов
        while (!heap.isEmpty()) {
            Element current = heap.poll();
            result.append(current.value).append(" ");

            // добавляем следующий элемент из текущего массива
            if (current.elementIndex + 1 < sizes[current.arrayIndex]) {
                heap.add(new Element(arrays[current.arrayIndex][current.elementIndex + 1], current.arrayIndex, current.elementIndex + 1));
            }
        }

        System.out.println(result.toString().trim());

        //конец
    }
}
