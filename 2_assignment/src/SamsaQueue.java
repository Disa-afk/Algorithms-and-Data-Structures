import java.util.*;

public class SamsaQueue {
    public static int countUnableToEat(int[] students, int[] samsas) {
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) q.add(s);

        int sIndex = 0;
        int skipped = 0;

        while (!q.isEmpty() && skipped < q.size()) {
            if (q.peek() == samsas[sIndex]) {
                q.poll();
                sIndex++;
                skipped = 0;
            } else {
                q.add(q.poll());
                skipped++;
            }
        }
        return q.size();
    }

    static void main(String[] args) {
        int[] st = {1, 1, 1, 0, 0, 1};
        int[] sa = {1, 0, 0, 0, 1, 1};
        System.out.println(countUnableToEat(st, sa));
    }
}