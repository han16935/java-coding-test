package baekjoon.topology;

import java.util.*;
import java.io.*;

public class 줄세우기_2252_IMPROVED {
    static int n, m;
    static List<Integer> answer = new ArrayList<>();
    static List<List<Integer>> arr = new ArrayList<>();
    static Deque<Integer> queue = new ArrayDeque<>();
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

        for (int k=1;k<=n;k++) {
            if (inDegree[k] == 0) {
                queue.offer(k);
                isVisited[k] = true;
            }
        }

        while (!queue.isEmpty()) {
            int currentStudent = queue.poll();
            List<Integer> nextStudentCandidates = arr.get(currentStudent);
            answer.add(currentStudent);

            for (int i=0;i<nextStudentCandidates.size();i++) {
                int nextStudentCandidate = nextStudentCandidates.get(i);

                if (!isVisited[nextStudentCandidate]) {
                    inDegree[nextStudentCandidate]--;

                    if (inDegree[nextStudentCandidate] == 0) {
                        queue.offer(nextStudentCandidate);
                        isVisited[nextStudentCandidate] = true;
                    }
                }
            }
        }

        for (int i=0;i<n;i++) {
            bw.write(String.valueOf(answer.get(i)) + " ");
        }

        bw.flush();
    }
}
