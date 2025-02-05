package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem2_재귀함수이용한이진수출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n, new StringBuilder());
    }

    private static void solution(int n, StringBuilder answer) {
        if (n==0) System.out.println(answer.reverse());
        else solution(n/2, answer.append(n%2));
    }
}
