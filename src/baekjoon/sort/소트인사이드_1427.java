package baekjoon.sort;

import java.util.*;
import java.io.*;

public class 소트인사이드_1427 {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = br.readLine();
        int [] arr = new int[numStr.length()];
        int num = Integer.parseInt(numStr);

        for (int digit=0;digit<arr.length;digit++) {
            arr[digit] = num % 10;
            num /= 10;
        }

        Arrays.sort(arr);
        for (int i=arr.length-1;i>=0;i--) {
            bw.write(String.valueOf(arr[i]));
        }
        bw.flush();
    }
}
