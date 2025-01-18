package inflearn.section2_array;

import java.io.*;
import java.util.StringTokenizer;

public class problem1_큰수출력하기 {

    private static void solution(int n, String strArr) {
        // 1. strArr 앞에 0 삽입
        StringBuilder sb = new StringBuilder(strArr);
        sb.insert(0, "0 ");
        strArr = sb.toString();
        int [] arr = new int[n+1];

        // 2. arr에 값 넣기
        StringTokenizer st = new StringTokenizer(strArr);
        int i = 0;
        while(st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        // 3. 자신보다 큰 수 출력
        for(int j=0;j<n;j++) {
            if (arr[j] < arr[j+1]) {
                System.out.print(arr[j+1]);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String strArr = br.readLine();
        solution(n, strArr);
    }
}
