package inflearn.section3_array;

import java.io.*;

public class problem1_큰수출력하기 {

    private static void solution(int n, String strArr) {
        // 1. strArr 앞에 0 삽입
        StringBuilder sb = new StringBuilder(strArr);
        sb.insert(0, "0 ");
        strArr = sb.toString();
        int [] arr = new int[n+1];

        // 2. arr에 값 넣기
        String[] s = strArr.split(" ");
        for(int i=0;i<s.length;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // 3. 자신보다 큰 수 출력
        for(int j=0;j<s.length-1;j++) {
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
