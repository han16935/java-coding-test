package baekjoon.simulation;

import java.util.*;
import java.io.*;


// R 연산 << rowCount 업데이트
// C 연산 << colCount 업데이트
public class 이차원배열과연산_17140_IMPORTANT {

    static int r, c, k;
    static int answer;
    static int [][] arr = new int[101][101];
    static int rowCount = 3; // 열 개수
    static int colCount = 3; // 행 개수
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // index 1부터 시작
        for (int i=1;i<=3;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (answer <= 100) {
            if (arr[r][c] == k) {
                System.out.println(answer);
                return;
            }

            if (rowCount > colCount) processR();
            else processC();
            pq.clear();

            answer++;
        }

        System.out.println(-1);
    }

    // 각 row 대해 정렬
    static void processR() {
        int tmpRowCount = 0;
        for (int colIndex=1;colIndex<=colCount;colIndex++) {

            // 특정 행에 있는 수 통계 구하기
            Map<Integer, Integer> map = new HashMap<>();
            for (int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
                if (arr[colIndex][rowIndex] != 0) {
                    if (!map.containsKey(arr[colIndex][rowIndex])) map.put(arr[colIndex][rowIndex], 1);
                    else map.put(arr[colIndex][rowIndex], map.get(arr[colIndex][rowIndex]) + 1);
                }
            }

            // pq 삽입
            for (int key : map.keySet()) {
                pq.offer(new Node(key, map.get(key)));
                tmpRowCount += 2;
            }

            tmpRowCount = Math.max(rowCount, tmpRowCount);

            // pq 내 데이터 기반으로 행 업데이트
            int current = 1;
            while (!pq.isEmpty()) {
                Node polledNode = pq.poll();
                int num = polledNode.num;
                int count = polledNode.count;

                arr[current++][colIndex] = num;
                arr[current++][colIndex] = count;
            }
        }
        rowCount = tmpRowCount;
    }

    // 각 col 대해 정렬 수행
    static void processC() {
        int tmpColCount = 0;
        for (int colIndex=1;colIndex<=colCount;colIndex++) {

            // 특정 행에 있는 수 통계 구하기
            Map<Integer, Integer> map = new HashMap<>();
            for (int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
                if (arr[rowIndex][colIndex] != 0) {
                    if (!map.containsKey(arr[rowIndex][colIndex])) map.put(arr[rowIndex][colIndex], 1);
                    else map.put(arr[rowIndex][colIndex], map.get(arr[rowIndex][colIndex]) + 1);
                }
            }

            // pq 삽입
            for (int key : map.keySet()) {
                pq.offer(new Node(key, map.get(key)));
                tmpColCount += 2;
            }

            tmpColCount = Math.max(colCount, tmpColCount);

            // pq 내 데이터 기반으로 행 업데이트
            int current = 1;
            while (!pq.isEmpty()) {
                Node polledNode = pq.poll();
                int num = polledNode.num;
                int count = polledNode.count;

                arr[current++][colIndex] = num;
                arr[current++][colIndex] = count;
            }
        }
        colCount = tmpColCount;
    }

    static class Node implements Comparable<Node> {
        int num;
        int count;

        public Node (int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node other) {
            if (this.count == other.count) return this.num - other.num;
            else return this.count - other.count;
        }
    }
}
