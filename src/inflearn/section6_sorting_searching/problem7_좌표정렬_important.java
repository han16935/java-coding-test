package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

public class problem7_좌표정렬_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> arr = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for(Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }
    }
}

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) return this.y-p.y;
        else return this.x-p.x;
    }
}
