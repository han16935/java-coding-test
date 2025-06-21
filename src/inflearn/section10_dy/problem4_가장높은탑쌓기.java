package inflearn.section10_dy;

import java.util.*;
import java.io.*;

public class problem4_가장높은탑쌓기 {

    static int n;
    static int answer;
    static List<Block> blocks = new ArrayList<>();
    static int [] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dy = new int[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            blocks.add(new Block(area, height, weight));
        }

        Collections.sort(blocks);
        for(int i=0;i<n;i++) {
            dy[i] = blocks.get(i).height;
        }

        for(int i=1;i<n;i++) {
            Block b = blocks.get(i);
            for(int j=0;j<i;j++) {
                if (b.weight > blocks.get(j).weight) {
                    dy[i] = Math.max(dy[i], dy[j] + b.height);
                }
            }
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    static class Block implements Comparable<Block> {

        int area;
        int height;
        int weight;

        public Block(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block other) {
            return this.area - other.area;
        }
    }
}
