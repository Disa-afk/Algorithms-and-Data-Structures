public static int sumSquare(int n) { // O(n)
    if(n!=1) return sumSquare(n-1) + n*n;
    else return n*n;
}

public static int sumArray(int[] arr, int n) { // O(n)
    if(n>0) return sumArray(arr, n-1) + arr[n];
    else return arr[n];
}

public static double sumNPowers(double n, double m) { // O(m)
    if(m!=0) return sumNPowers(n, m-1) + Math.pow(n, m);
    else return Math.pow(n, m);
}

public static void reverse(int n, Scanner sc) { // O(n)
    if (n <= 0) {
        return;
    }

    int num = sc.nextInt();

    reverse(n - 1, sc);

    System.out.print(num + " ");
}

void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = sc.nextInt();
    System.out.println(sumSquare(n));
    System.out.println("Enter the size of the array:");
    n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println("Enter the index:");
    n = sc.nextInt();
    System.out.println(sumArray(arr, n));
    System.out.println("Enter the number:");
    double k = sc.nextInt();
    System.out.println("Enter the power:");
    double m = sc.nextInt();
    System.out.println((int)sumNPowers(k, m));
    System.out.println("Enter the number:");
    n = sc.nextInt();
    reverse(n, sc);
}
