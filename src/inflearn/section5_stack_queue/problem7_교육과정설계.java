package inflearn.section5_stack_queue;

import java.util.*;
import java.io.*;

public class problem7_교육과정설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String essentialLecture = br.readLine();
        String s = br.readLine();

        String answer = "NO";
        int essentialPtr = 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == essentialLecture.charAt(essentialPtr)) {
                essentialPtr++;
            }

            if (essentialPtr == essentialLecture.length()) {
                answer = "YES";
                break;
            }
        }

        System.out.println(answer);
    }
}
