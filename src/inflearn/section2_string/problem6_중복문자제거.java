package inflearn.section2_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class problem6_중복문자제거 {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       StringBuilder answer = new StringBuilder();
       Set<Character> set = new HashSet<>();

       for(int i=0;i<str.length();i++){
           if(!set.contains(str.charAt(i))) {
               set.add(str.charAt(i));
               answer.append(str.charAt(i));
           }
       }

       System.out.println(answer);
    }
}
