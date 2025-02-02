package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

public class problem5_중복확인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean [] isAlreadyExist = new boolean[100001];
        boolean isDuplicateNum = false;

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isAlreadyExist[num]) {
                isDuplicateNum = true;
                break;
            }
            isAlreadyExist[num] = true;
        }

        System.out.println(isDuplicateNum ? "D" : "U");
    }
}
