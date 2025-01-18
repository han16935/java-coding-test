package inflearn.section1_string;

import java.io.*;

/**
 * 입력으로 들어오는 문자열 뒤에 빈 문자열을 넣어 코드 단순화
 *
 */
public class problem11_문자열압축_재풀이 {
    private static String solution(String s) {
        s = s + " ";
        StringBuilder answer = new StringBuilder();
        int compressedSize = 1;

        for(int i=1;i<s.length();i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                answer.append(s.charAt(i-1));
                if (compressedSize > 1) {
                    answer.append(compressedSize);
                    compressedSize=1;
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
