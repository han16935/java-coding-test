package inflearn.section5_stack_queue;

import java.io.*;
import java.util.*;

public class problem2_괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            if (!dq.isEmpty() && s.charAt(i) == ')') {
                while (dq.peekLast() != '(') dq.removeLast();
                dq.removeLast();
            }
            else dq.addLast(s.charAt(i));
        }

        while (!dq.isEmpty()) {
            System.out.print(dq.pollFirst());
        }
    }
}
