package inflearn.section2_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class problem5_특정문자뒤집기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int start = 0;
        int end = s.length-1;
        while(start < end) {
            if (Character.isAlphabetic(s[start]) && Character.isAlphabetic(s[end])){
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;
                end--;
                continue;
            }

            if (!Character.isAlphabetic(s[start])) start++;
            if (!Character.isAlphabetic(s[end])) end--;
        }
        System.out.println(s);
    }
}
