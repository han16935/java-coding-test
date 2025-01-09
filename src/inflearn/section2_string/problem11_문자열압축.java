package inflearn.section2_string;

import java.io.*;
import java.util.*;

public class problem11_문자열압축 {
    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int compressedSize = 1;

        for(int i=1;i<s.length();i++) {

            if (i == s.length() - 1 && s.charAt(i-1) == s.charAt(i)) {
                answer.append(s.charAt(i-1));
                answer.append(compressedSize + 1);
            }

            if (s.charAt(i-1) != s.charAt(i)) {
                answer.append(s.charAt(i-1));
                if (compressedSize > 1) {
                    answer.append(compressedSize);
                    compressedSize = 1;
                }
                if(i == s.length() - 1) {
                    answer.append(s.charAt(i));
                }
            }

            else compressedSize++;
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
