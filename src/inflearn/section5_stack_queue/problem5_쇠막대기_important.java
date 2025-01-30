package inflearn.section5_stack_queue;

import java.util.*;
import java.io.*;

/**
 * 괄호 문제는 일단 스택으로 생각하자!
 * 그림을 보면 조각이 생기는 때에는 ) 를 만날 때,
 * 이는 즉 레이저를 만나거나, 막대기의 끝일 때이다.
 * 레이저를 만날 경우 발생하는 조각은 당시 아래에 있던 막대기의 개수, 즉 stack 안 (의 개수이다!
 * 막대기의 끝일 경우 발생하는 조각은 1개, 왜냐하면 앞서 레이저로 발생한 조각은 전부 회수했기 때문!
 *
 * 레이저의 경우 바로 직전 괄호가 (일 경우이므로, 이를 이용해 조건문 작성함
 */
public class problem5_쇠막대기_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s.length(), s));
    }

    private static int solution(int n, String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if (c == ')') {
                dq.removeLast();
                // 1. 만약 레이저일 경우
                if (s.charAt(i-1) == '(') answer+=dq.size();

                // 2. 만약 막대기의 끝일 경우
                else answer++;
            }
            else dq.addLast(c);
        }
        return answer;
    }
}
