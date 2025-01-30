package inflearn.section5_stack_queue;

import java.util.*;

/**
 *  Queue 안에 왕자 번호를 전부 넣고, k번째 왕자는 그대로 제거, 아닐 때에는 다시 뒤에 넣기
 *
 */
public class problem6_공주구하기_inflearn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        // 1. queue 초기화
        for(int i=1;i<=n;i++) {
            dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            // 1. queue 앞에 있는 녀석들 뒤로 빼기
            for(int i=0;i<k-1;i++) {
                dq.addLast(dq.removeFirst());
            }

            dq.removeFirst();
            if (dq.size() == 1) break;
        }

        return dq.peek();
    }
}
