package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

/**
 * 결혼식 시작 시간, 끝나는 시간을 S, E로 해서 시간순 정렬! (ex) 5 S, 12 S, 14 E, 14 S, ...)
 *    - 이 때, 시간이 같다면 e가 앞으로! (끝나는 시간이 되면 이미 그 사람은 결혼식장에 없으므로)
 *    - count와 answer를 통해 count의 최댓값을 answer에 넣자!
 */
public class problem3_결혼식_IMPORTANT {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Element> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Element(Integer.parseInt(st.nextToken()), 1));
            arr.add(new Element(Integer.parseInt(st.nextToken()), 0));
        }

        Collections.sort(arr);

        int count = 0;
        int answer = 0;

        for (Element e : arr) {
            if (e.isStartTime == 1) count++;
            if (e.isStartTime == 0) count--;
            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    static class Element implements Comparable<Element> {
        int time;
        int isStartTime;

        public Element(int time, int isStartTime) {
            this.time = time;
            this.isStartTime = isStartTime;
        }

        @Override
        public int compareTo(Element e) {
            if (this.time == e.time) {
                return this.isStartTime - e.isStartTime;
            }

            return this.time - e.time;
        }
    }

}
