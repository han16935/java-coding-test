package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

/**
 * 조합을 통해 문자열 생성 + 특정 수 만큼 자음/모음을 포함하고 있는 지 확인!
 *    - 백준 내 예제 출력을 보니 입력받은 문자 정렬해야 해서 정렬 (안 하면 저 순서대로 안 나옴!)
 *    - aeiou 를 통해 모음 수 체크!
 *    - new String(char [] ) 로 char [] 을 String 으로 바꿀 수 잇음!
 *
 */
public class 암호만들기_1759_IMPORTANT {

    static int l;
    static int c;
    static char [] alphabets;
    static char [] answer;
    static boolean [] isVisited;

    static List<Character> aeiou = List.of('a', 'e', 'i', 'o', 'u');

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabets = new char [c];
        isVisited = new boolean [c];
        answer = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<c;i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabets);

        solution(0, 0);
    }

    public static void solution(int start, int length) {

        if (length == l) {
            int aeiouCount = 0;
            int otherCount = 0;

            for(int i=0;i<l;i++) {
                if (aeiou.contains(answer[i])) aeiouCount++;
                else otherCount++;
            }

            if (aeiouCount < 1 || otherCount < 2) return;
            System.out.println(new String(answer)); //
        }

        if (length >= l) {
            return;
        }

        else {
            for (int i=start;i<c;i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    answer[length] = alphabets[i];
                    solution(i + 1, length + 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
