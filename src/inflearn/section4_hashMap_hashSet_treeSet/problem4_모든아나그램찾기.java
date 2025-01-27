package inflearn.section4_hashMap_hashSet_treeSet;

import java.io.*;
import java.util.*;

public class problem4_모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int answer = 0;
        int lt = 0;
        int rt = 0;
        int length = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // 1. TMAP 초기화
        for(int i=0;i<t.length();i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (rt < s.length()) {

           if (length < t.length()) {
               sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
               rt++;
           }

           else if (length == t.length()) {
               boolean isAnagram = isAnagram(sMap, tMap);
               if (isAnagram) {
                   answer++;
               }

               if (sMap.get(s.charAt(lt)) == 1) sMap.remove(s.charAt(lt));
               else sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
               lt++;
           }

           length = rt - lt;
        }

        boolean isAnagram = isAnagram(sMap, tMap);
        if (isAnagram) {
            answer++;
        }

        return answer;
    }

    private static boolean isAnagram(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        return sMap.equals(tMap);
    }
}
