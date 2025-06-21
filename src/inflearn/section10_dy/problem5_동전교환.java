package inflearn.section10_dy;

import java.util.*;
import java.io.*;

public class problem5_동전교환 {

    static int n;
    static int [] coinList;
    static int m;
    static int [] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        coinList = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            coinList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for(int coin : coinList) {
            for(int i=coin;i<=m;i++) {
                dy[i] = Math.min(dy[i], dy[i-coin] + 1);
            }
        }

        System.out.println(dy[m]);
    }
}
