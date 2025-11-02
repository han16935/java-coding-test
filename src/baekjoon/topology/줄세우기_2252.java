package baekjoon.topology;

import java.util.*;
import java.io.*;

public class 줄세우기_2252 {
    static int n, m;
    static List<Integer> answer = new ArrayList<>();
    static List<List<Integer>> arr = new ArrayList<>();
    static int [] inDegree;
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }
        inDegree = new int[n + 1];
        isVisited = new boolean[n + 1];

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int firstStudent = Integer.parseInt(st.nextToken());
            int secondStudent = Integer.parseInt(st.nextToken());

            arr.get(firstStudent).add(secondStudent);
            inDegree[secondStudent]++;
        }

        while (answer.size() < n) {
            int nextStudent = findNextStudent();
            isVisited[nextStudent] = true;
            answer.add(nextStudent);
            List<Integer> nextStudentCandidates = arr.get(nextStudent);
            for (int i=0;i<nextStudentCandidates.size();i++) {
                int nextStudentCandidate = nextStudentCandidates.get(i);
                if (!isVisited[nextStudentCandidate]) {
                    inDegree[nextStudentCandidate]--;
                }
            }
        }

        for (int i=0;i<n;i++) {
            bw.write(String.valueOf(answer.get(i)) + " ");
        }

        bw.flush();
    }

    static int findNextStudent() {
        int studentIndex = -1;
        for (int i=1; i<=n ;i++) {
            if (!isVisited[i] && inDegree[i] == 0) {
                studentIndex = i;
                break;
            }
        }
        return studentIndex;
    }
}
