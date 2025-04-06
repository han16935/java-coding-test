package inflearn.section8_dfs_bfs;

import java.util.*;

/*
    주목해야 할 부분은 아래 F (16) 이 아닌 위 부분 (3, 1, 2, 4)
    ex) N이 4라면 3C0, 3C1, 3C2, 3C3을 각각 위 부분에 곱하면 F가 나옴!
         - 3 * 3C0 + 1 * 3C1 + 2 * 3C2 + 4 * 3C3 = 16

     1~N 수를 기준으로 Permutation을 만들고, 계산해둔 Combination 과 곱해 계산해보기
 */

public class problem8_수열추측하기_IMPORTANT {

    static int n, f;
    static int [] combinations; // 곱할 combination 값 저장
    static int [] answers;
    static boolean [] isVisited;
    static boolean isAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        combinations = new int[n];
        answers = new int[n];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            combinations[i] = calculateCombination(n - 1, i);
        }

        solution(0);
    }

    private static void solution(int index) {
        if (isAnswer) return;

        if (index == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += answers[i] * combinations[i];
            }

            if (sum == f) {
                for (int i = 0; i < n; i++) {
                    System.out.print(answers[i] + " ");
                }
                isAnswer = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    answers[index] = i;
                    solution(index + 1);
                    isVisited[i] = false;
                }
            }
        }
    }

    private static int calculateCombination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (r == 1) return n;
        else return calculateCombination(n - 1, r - 1) + calculateCombination(n - 1, r);
    }
}
