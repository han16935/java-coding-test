package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem3_최대점수구하기 {

    static int n, m;
    static int answer = 0;
    static List<Quiz> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.add(new Quiz(score, time));
        }

        solution(-1, 0, 0);
        System.out.println(answer);
    }

    private static void solution(int quizIndex, int passedTime,int currentScore) {
        if (passedTime > m) return;
        if (currentScore > answer) answer = currentScore;
        if (quizIndex + 1 == n) {
            return;
        }
        Quiz currentQuiz = list.get(quizIndex+1);

        solution(quizIndex + 1, currentQuiz.time + passedTime, currentQuiz.score + currentScore);
        solution(quizIndex + 1, passedTime, currentScore);
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
