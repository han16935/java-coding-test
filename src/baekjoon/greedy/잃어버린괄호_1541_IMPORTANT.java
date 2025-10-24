package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class 잃어버린괄호_1541_IMPORTANT {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
           String token = st.nextToken();
           int sum = calculateSum(token);

           if (answer == Integer.MAX_VALUE) answer = sum;
           else answer -= sum;
        }

        System.out.println(answer);
    }

    static int calculateSum(String token) {
        int sum = 0;
        StringTokenizer plusSt = new StringTokenizer(token, "+");
        while (plusSt.hasMoreTokens()) {
            sum += Integer.parseInt(plusSt.nextToken());
        }
        return sum;
    }
}
