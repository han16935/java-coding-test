package inflearn.section5_stack_queue;

import java.io.*;
import java.util.*;

public class problem4_후위식연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Integer> dq = new ArrayDeque<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' ||
                c == '*' || c == '/') {
                int secondNum = dq.removeLast();
                int firstNum = dq.removeLast();

                if (c == '+') dq.addLast(firstNum + secondNum);
                if (c == '-') dq.addLast(firstNum - secondNum);
                if (c == '*') dq.addLast(firstNum * secondNum);
                if (c == '/') dq.addLast(firstNum / secondNum);
            }
            else dq.addLast(Integer.parseInt(String.valueOf(c)));
        }
        System.out.println(dq.peekLast());
    }
}
