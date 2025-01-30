package inflearn.section5_stack_queue;

import java.util.*;
import java.io.*;

/**
 * pq 안에는 환자의 긴급도를, patientMap에는 키로 순서, value로 긴급도를 넣고
 * patientMap의 제일 최상위 요소의 긴급도가 pq의 peek() 햇을 때의 긴급도와 같다면 answer++
 *
 * 인프런에는 환자의 순서와 긴급도 넣어 class 만들어서 큐에 전부 넣고 돌아가며 해결!
 */
public class problem8_응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int urgency = Integer.parseInt(st.nextToken());
            map.put(i, urgency);
            pq.add(urgency);
        }

        System.out.println(solution(n, m, pq, map));
    }

    private static int solution(int n, int m, PriorityQueue<Integer> pq, Map<Integer, Integer> patientMap) {
        int answer = 0;
        int patientNum = 0;
        boolean [] isTreated = new boolean[n];
        while(!patientMap.isEmpty()) {

            // 1. 현재 map의 최상위 환자가 긴급도가 제일 높다면, pq/map에서 환자 제거!
            if (pq.peek() == patientMap.get(patientNum)) {
                answer++;
                if (patientNum == m) break;

                pq.poll();
                isTreated[patientNum] = true;
            }

            patientNum = (patientNum + 1) % n;
            while (isTreated[patientNum]) {
                patientNum = (patientNum + 1) % n;
            }
        }
        return answer;
    }
}
