package baekjoon.greedy;

import java.util.*;
import java.io.*;

/**
 * 특정 로프의 집합이 버틸 수 있는 무게의 최댓값을 구하기 위해서는
 * 로프 집합 내 최솟값 * 로프 집합의 요소 개수를 구하면 됨!
 *    15 -> 15 * 1 = 15
 *    (15, 10) -> 10 * 2 = 20
 *
 */
public class 로프_2217 {

    static int n;
    static int answer = 0; // 최대 무게 저장
    static int ropeCount = 0;
    static int weightSum = 0;
    static List<Integer> ropeList = new ArrayList<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            ropeList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropeList, Collections.reverseOrder());

        ropeCount = 1;
        weightSum = ropeList.get(0);
        answer = ropeList.get(0);
        int lt = 0;
        int rt = 1;

        while (lt < n && rt < n) {
            weightSum += ropeList.get(rt);
            ropeCount++;
            answer = Math.max(answer, ropeList.get(rt) * ropeCount);
            rt++;
        }

        System.out.println(answer);
    }
}
