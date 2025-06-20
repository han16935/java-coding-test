package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

/**
 * Union & Find 연산
 *   초기 배열을 다음과 같이 초기화
 *   1 2 3 4 5 6 7 8 9
 *   1 2 3 4 5 6 7 8 9
 *
 *   위 배열을 통해 각 인원이 어떤 집합에 속해 있는 지 find() 를 통해 파악!
 *   그리고 union() 을 통해 두 친구를 하나의 집합에 속하도록 구성
 *
 *
 *
 *
 */
public class problem6_친구인가_IMPORTANT {

    static int n;
    static int m;
    static int [] arr;

    public static int find(int friend) {
        if (arr[friend] == friend) return friend;
        else return arr[friend] = find(arr[friend]);
    }

    public static void union(int start, int end) {
        int startSet = find(start);
        int endSet = find(end);
        if (startSet != endSet) arr[end] = startSet;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=1;i<=n;i++) {
            arr[i] = i;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);
        }

        st = new StringTokenizer(br.readLine());
        int finalStart = Integer.parseInt(st.nextToken());
        int finalEnd = Integer.parseInt(st.nextToken());

        if (find(finalStart) == find(finalEnd)) System.out.println("YES");
        else System.out.println("NO");
    }
}
