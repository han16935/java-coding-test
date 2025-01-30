package inflearn.section5_stack_queue;

import java.util.*;
import java.io.*;

/**
 * 공주구하기 solution (나의 풀이)
 * princeNum을 업데이트하면서 (이미 탈락한 왕자는 패스)
 * 탈락한 왕자를 배열에 기록, queue를 클리어하면서 풀이!
 *
 */
public class problem6_공주구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int remainPrinceCnt = n;
        int princeNum = 1; // 들어갈 prince count
        int dropCount = 1; // dropCount == k 일 때 isDropped 갱신
        boolean [] isDropped = new boolean[n+1]; // false로 초기화

        while (remainPrinceCnt > 1) {

            while (dropCount < k) {
                dq.addLast(princeNum);
                princeNum = (princeNum % n) + 1;
                while (isDropped[princeNum]) {
                    princeNum = (princeNum % n) + 1;
                }
                dropCount++;
            }

            isDropped[princeNum] = true;
            remainPrinceCnt--;

            princeNum = (princeNum % n) + 1;
            while (isDropped[princeNum]) {
                princeNum = (princeNum % n) + 1;
            }

            dropCount = 1;
            if (remainPrinceCnt == 1) break;
            dq.clear();
        }
        return dq.peekLast();
    }
}
