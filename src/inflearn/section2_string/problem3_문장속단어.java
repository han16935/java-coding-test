package inflearn.section2_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem3_문장속단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sentence = reader.readLine();
        String[] arr = sentence.split(" ");
        int answerIndex = -1;
        int maxLength = 0;

        for(int i=0;i<arr.length;i++) {
            if (arr[i].length() > maxLength) {
                maxLength = arr[i].length();
                answerIndex = i;
            }
        }

        System.out.println(arr[answerIndex]);
    }
}
