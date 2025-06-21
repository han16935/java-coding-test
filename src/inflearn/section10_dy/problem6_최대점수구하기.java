package inflearn.section10_dy;

import java.util.*;
import java.io.*;

public class problem6_최대점수구하기 {

    static int n;
    static int m;
    static List<Quiz> quizList = new ArrayList<>();
    static int [] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dy = new int[m + 1];
        Arrays.fill(dy, 0);

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            quizList.add(new Quiz(score, time));
        }

        for(Quiz quiz : quizList) {
            for(int i=m;i>=quiz.time;i--) {
                dy[i] = Math.max(dy[i], dy[i-quiz.time] + quiz.score);
            }
        }

        System.out.println(dy[m]);
    }

    static class Quiz {
        int score;
        int time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
