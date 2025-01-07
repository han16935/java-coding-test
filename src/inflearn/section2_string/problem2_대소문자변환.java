package inflearn.section2_string;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class problem2_대소문자변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
               answer.append( (char) (c - 32));
            }
            else{
               answer.append((char) (c + 32));
            }
        }

        System.out.println(answer);
    }
}
