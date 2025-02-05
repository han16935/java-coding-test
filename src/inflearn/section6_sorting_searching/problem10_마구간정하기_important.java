package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

/**
 * ex) mid = 5일 때 가장 가까운 두 말의 최대 거리가 5인지 보는 것이므로
 *     말 사이 거리는 5 이상이여야!
 *
 *     lt, rt는 계산해서 현재 말 사이 최소 거리, 혹은 최대 거리를 구해도 되지만
 *     binary search는 O(log n) 이므로 굳이?
 */
public class problem10_마구간정하기_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];

        System.out.println(solution(n, c, arr, lt, rt, -1));
    }

    private static int solution(int n, int horseCount, int[] arr, int lt, int rt, int answer) {
        int mid = (lt + rt)/2;
        if (lt > rt) return answer;
        else if (canPlaceHorsesGoeMidDistance(n, horseCount, arr, mid)) return solution(n, horseCount, arr, mid+1, rt, mid);
        else return solution(n, horseCount, arr, lt, mid - 1, answer);
    }

    private static boolean canPlaceHorsesGoeMidDistance(int n, int horseCount, int[] arr, int dis) {
        int lastPos = arr[0];
        int cnt = 1;

        for(int i=1;i<n;i++) {
            if (arr[i] - lastPos >= dis) {
                lastPos = arr[i];
                cnt++;
            }
        }

        return (cnt >= horseCount) ? true : false;
    }
}
