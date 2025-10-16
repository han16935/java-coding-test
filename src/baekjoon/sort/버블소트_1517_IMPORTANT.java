package baekjoon.sort;

import java.util.*;
import java.io.*;

public class 버블소트_1517_IMPORTANT {

    static int n;
    static long answer;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        divide(0, n - 1);

        System.out.println(answer);
    }

    static void divide (int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        merge(start, mid, end);
    }

    // start-mid, mid+1-end merge
    static void merge (int start, int mid, int end) {

        int firstPointer = start;
        int secondPointer = mid + 1;

        int length = end - start + 1;
        int [] tmp = new int[length];
        int tmpIndex = 0;

        while (firstPointer <= mid && secondPointer <= end) {
            if (arr[firstPointer] == arr[secondPointer]) {
                tmp[tmpIndex++] = arr[firstPointer++];
            }

            if (firstPointer <= mid && secondPointer <= end && arr[firstPointer] < arr[secondPointer]) {
                tmp[tmpIndex++] = arr[firstPointer++];
            }

            if (firstPointer <= mid && secondPointer <= end && arr[secondPointer] < arr[firstPointer]) {
                int swapDistance = mid - firstPointer + 1;
                answer += swapDistance;
                tmp[tmpIndex++] = arr[secondPointer++];
            }
        }

        while (firstPointer <= mid) {
            tmp[tmpIndex++] = arr[firstPointer++];
        }

        while (secondPointer <= end) {
            tmp[tmpIndex++] = arr[secondPointer++];
        }

        tmpIndex = 0;
        for (int originalArrIndex = start; originalArrIndex <= end; originalArrIndex++) {
            arr[originalArrIndex] = tmp[tmpIndex++];
        }

    }
}
