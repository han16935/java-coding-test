package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem1_합이같은부분집합_important {

    static int n;
    static int [] arr;
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(-1, new Subsets(0, 0));
        System.out.println(answer ? "YES" : "NO");
    }

    /**
     * 왼쪽 subset에 element를 넣을 건지, 혹은 오른쪽에 넣을 건지 선택
     * @param index
     * @param ss
     */
    private static void solution(int index, Subsets ss) {
        if (answer) return;
        if (index==n-1) {
            if (ss.isSameSubset()) answer = true;
            return;
        }

        int nextElement;
        if (index+1==n) nextElement = arr[index];
        else nextElement = arr[index + 1];

        solution(index+1, ss.chooseFirstSubset(nextElement));
        solution(index+1, ss.chooseSecondSubset(nextElement));
    }

    static class Subsets {
        int firstSubset;
        int secondSubset;

        public Subsets(int firstSubset, int secondSubset) {
            this.firstSubset = firstSubset;
            this.secondSubset = secondSubset;
        }

        public boolean isSameSubset() {
            return firstSubset !=0 && secondSubset != 0 && firstSubset == secondSubset;
        }

        public Subsets chooseFirstSubset(int element) {
            return new Subsets(firstSubset + element, secondSubset);
        }

        public Subsets chooseSecondSubset(int element) {
            return new Subsets(firstSubset, secondSubset + element);
        }
    }
}
