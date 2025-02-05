package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

/**
 * 결정 알고리즘 > 특정 범위 안에 정답이 반드시 있을 경우에 사용!
 * 이 뮤직비디오 경우 dvd의 크기가 dvd 중 가장 길이가 긴 minute와 전체 길이 합계 사이 반드시 존재!
 *    - binary search 이용해 최소 길이 구하기!
 *
 */
public class problem9_뮤직비디오_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int lt = 0, rt = 0;
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == n-1) lt = arr[i];
            rt += arr[i];
        }


        System.out.println(solution(n, m, arr, lt, rt, -1));
    }

    private static int solution(int n, int m, int[] arr, int lt, int rt, int answer) {
        int mid = (lt + rt) / 2;
        if (lt > rt) return answer;
        else if (canSaveSongsInMidSizeDvd(n, m, mid, arr)) return solution(n, m, arr, lt, mid-1, mid);
        else return solution(n, m, arr, mid+1, rt, answer);
    }

    private static boolean canSaveSongsInMidSizeDvd(int n, int dvdCount, int dvdCapacity, int[] arr) {
        int count = 1; // dvd는 1개 이상은 무조건 사용되므로 1부터 시작
        int savedDvdMinutes = 0;
        for(int i=0;i<n;i++) {
            if (count > dvdCount) return false;
            if (savedDvdMinutes + arr[i] > dvdCapacity) {
                count++;
                savedDvdMinutes = arr[i];
            }

            else savedDvdMinutes += arr[i];
        }
        if (count > dvdCount) return false;
        return true;
    }
}
