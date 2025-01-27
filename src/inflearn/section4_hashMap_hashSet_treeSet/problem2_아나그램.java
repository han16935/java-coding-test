package inflearn.section4_hashMap_hashSet_treeSet;

import java.io.*;
import java.util.*;

public class problem2_아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }

    private static String solution(String s1, String s2) {
        boolean answer = true;
        if (s1.length() != s2.length()) return "NO";

        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for(int i=0;i<s1.length();i++) {
            h1.put(s1.charAt(i), h1.getOrDefault(s1.charAt(i), 0) + 1);
            h2.put(s2.charAt(i), h2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(char c : h1.keySet()) {
           if (h1.get(c) != h2.get(c)) {
               answer = false;
               break;
           }
        }

        return answer ? "YES" : "NO";
    }
}
