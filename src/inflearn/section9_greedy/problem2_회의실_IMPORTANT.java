package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

/**
 * 회의 시간이 끝나는 시간을 기준으로 오름차순, 만약 끝나는 시간이 같다면 시작 시간 기준 오름차순 정렬!
 *    - 시작 시간을 기준으로 정렬할 경우, 예를 들어 (1~4) (2~3) (3~5) 가 있을 때 하나만 먹고 두 개는 못 먹음
 *    - 정렬 후 first element의 회의 끝나는 시간을 저장한 뒤, 순회하면서 각 요소의 회의 시작하는 시간이 endTime 이상일 경우 update 및 answer++
 *
 *    - 오답 : 시작 시간, 종료 시간이 아닌 두 시간의 차를 기준으로 정렬!
 *
 *          - 3 3
 *          - 2 3
 *          - 1 3
 *          - 4 6
 *          - 5 7
 *
 *          - 3 3
 *
 *          위 케이스의 경우 (3 3), (2 3) 이 들어가고, endTime이 3 < 6이로 (4 6), 6 < 7이므로 (5 7) 까지 들어가서 답이 4가 나옴! (터짐)
 *
 */
public class problem2_회의실_IMPORTANT {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        MeetingRoom [] meetingRooms = new MeetingRoom[n];

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingRooms[i] = new MeetingRoom(start, end);
        }

        Arrays.sort(meetingRooms);

        int endTime = meetingRooms[0].end;

        for(int i=1;i<n;i++) {
            if (endTime <= meetingRooms[i].start) {
                endTime = meetingRooms[i].end;
                answer++;
            }
        }


        System.out.println(answer);
    }

    static class MeetingRoom implements Comparable<MeetingRoom> {

        int start;
        int end;

        public MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingRoom m) {
            if (this.end == m.end) return this.start - m.start;
            return this.end - m.end;
        }
    }
}
