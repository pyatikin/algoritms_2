import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            heap.add(scanner.nextInt());
        }

        double totalCost = 0;

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            int sum = first + second;
            totalCost += sum * 0.05;
            heap.add(sum);
        }

        System.out.println(totalCost);


        //конец
    }
}
