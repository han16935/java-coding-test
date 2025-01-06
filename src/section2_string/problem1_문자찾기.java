package section2_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1_문자찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().toLowerCase();
        char c = br.readLine().toLowerCase().charAt(0);
        int answer = 0;

        for(char s: sentence.toCharArray()) {
            if (s == c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}