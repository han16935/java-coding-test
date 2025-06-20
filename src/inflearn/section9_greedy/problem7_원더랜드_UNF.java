package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

/**
 * edge list 받은 후 weight 오름차순 정렬
 * 같은 set 에 속하지 않는 경우 union() 후 set 합침
 *
 *
 */
public class problem7_원더랜드_UNF {

    static int v;
    static int e;
    static int answer;
    static int [] arr;
    static List<Edge> edgeList = new ArrayList<>();

    public static int find (int city) {
        if (arr[city] == city) return city;
        else return arr[city] = find(arr[city]);
    }

    public static void union (int firstCity, int secondCity) {
        int firstSet = find(firstCity);
        int secondSet = find(secondCity);
        if (firstSet != secondSet) arr[firstSet] = secondSet; // 주의 !!!
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arr = new int[v + 1];
        for(int i=1;i<=v;i++) {
            arr[i] = i;
        }

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(start, end, weight));
        }

        Collections.sort(edgeList);

        for (Edge e : edgeList) {
            int start = e.start;
            int end = e.end;

            if (find(start) != find(end)) {
                union(start, end);
                answer += e.weight;
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return start + " " + end + " " + weight;
        }
    }
}
