package inflearn.section10_dy;

import java.util.Scanner;

public class problem2_돌다리건너기 {
    static int n;
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        n++;
        dy = new int[n + 1];
        fibonacci(n);
        System.out.println(dy[n]);
    }

    static int fibonacci(int n) {
        if (n == 0) return dy[n] = 1;
        if (n == 1) return dy[n] = 1;

        else return dy[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
