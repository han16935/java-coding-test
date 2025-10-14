package baekjoon.stack;

import java.util.*;
import java.io.*;

public class 오큰수_17298_IMPORTANT {

    static int n;
    static int [] arr;
    static int [] answer;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int index=0;index<n;index++) {
            if (stack.isEmpty()) stack.push(index);
            else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
                    answer[stack.peek()] = arr[index];
                    stack.pop();
                }
                stack.push(index);
            }
        }

        for (int j=0;j<n;j++) {
            if (answer[j] == 0) bw.write(-1 + " ");
            else bw.write(answer[j] + " ");
        }

        bw.flush();
    }
}
