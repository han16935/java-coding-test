package baekjoon.stack;

import java.util.*;
import java.io.*;

public class 스택수열_1874 {
    static int n;
    static int [] arr;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int stackPushNumber = 1;
        int arrIndex = 0;

        while (stackPushNumber <= n) {
            stack.push(stackPushNumber);
            sb.append("+" + "\n");
            stackPushNumber++;

            while (!stack.isEmpty() && stack.peek() == arr[arrIndex]) {
                stack.pop();
                sb.append("-" + "\n");
                arrIndex++;
            }
        }

        while(!stack.isEmpty() && stack.peek() == arr[arrIndex]) {
            stack.pop();
            sb.append("+" + "\n");
            arrIndex++;
        }

        if (stack.isEmpty()) System.out.print(sb);
        else System.out.print("NO");
    }
}
