package inflearn.section1_string;

import java.io.*;

/**
 * 가장짧은문자거리
 *    - 1. 자신을 기준으로 왼쪽에 있는 e의 최소거리 구함
 *            - teachermode e
 *           101 0123012340
 *            - t 왼쪽에는 e가 없으므로 maxDis 값 그대로 넣기
 *
 *    - 2. 자신을 기준으로 오른쪽에 있는 e의 최소거리 구함
 *            - 이 때, 1에서 구한 왼쪽 e의 최소거리와 비교해서 넣기
 *
 *
 */
public class problem10_가장짧은문자거리_재풀이 {
    private static String solution(String s, char t) {
        int [] dis = new int[s.length()];
        int maxDis = 100;

        // 1. 왼쪽에 있는 e를 대상으로 최소거리 구하기
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) != t) dis[i] = ++maxDis;
            else dis[i] = maxDis = 0;
        }

        // 2. 오른쪽에 있는 e를 대상으로 최소거리 구하기
        for(int j=s.length()-1;j>=0;j--) {
            // 그 후 왼쪽 e 대상으로 한 거리와 비교
            if (s.charAt(j) != t) dis[j] = Math.min(dis[j], ++maxDis);
            else maxDis = 0;
        }

        StringBuilder answer = new StringBuilder();
        for(int k=0;k<s.length()-1;k++) {
            answer.append(dis[k] + " ");
        }
        answer.append(dis[s.length()-1]);
        return answer.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputArr = br.readLine().split(" ");
        System.out.println(solution(inputArr[0], inputArr[1].charAt(0)));
    }
}
