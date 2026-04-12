import java.util.*;

public class ListManager {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String action = sc.next();
            if (action.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                l.add(index, value);
            } else if (action.equals("Delete")) {
                int index = sc.nextInt();
                l.remove(index);
            }
        }

        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + (i == l.size() - 1 ? "" : " "));
        }
        sc.close();
    }
}