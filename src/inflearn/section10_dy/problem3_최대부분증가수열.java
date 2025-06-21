package inflearn.section10_dy;

import java.util.*;
import java.io.*;

public class problem3_최대부분증가수열 {

    static int n;
    static int answer;
    static int [] arr;
    static int [] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dy = new int[n];
        Arrays.fill(dy, 1);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++) {
            int endOfSequence = arr[i];
            for(int j=0;j<i;j++) {
                if (arr[j] < endOfSequence) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

}
