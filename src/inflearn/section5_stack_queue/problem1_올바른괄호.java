package inflearn.section5_stack_queue;

import java.io.*;
import java.util.*;

public class problem1_올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') dq.addLast('(');
            else if (dq.size() > 0 && dq.peekLast() == '(') dq.removeLast();
            else dq.addLast(s.charAt(i));
        }

        if (dq.size() > 0) return "NO";
        return "YES";
    }
}
