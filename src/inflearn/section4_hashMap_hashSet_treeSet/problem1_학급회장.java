package inflearn.section4_hashMap_hashSet_treeSet;

import java.io.*;
import java.util.*;

public class problem1_학급회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        HashMap<Character, Integer> h = new HashMap<>();

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
//            if (h.containsKey(c)) {
//                Integer value = h.get(c);
//                h.put(c, value + 1);
//            }
//            else h.put(c, 1);
        }

        int answerCnt = 0;
        Set<Character> ks = h.keySet();
        char answer = (char) ks.toArray()[0];
        for (char c : ks) {
            if (h.get(c) > answerCnt) {
                answerCnt = h.get(c);
                answer = c;
            }
        }

        System.out.println(answer);
    }
}
