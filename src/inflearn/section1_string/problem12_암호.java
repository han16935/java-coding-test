package inflearn.section1_string;

import java.io.*;

public class problem12_암호 {

    private static String solution(int n, String pw) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<n;i++) {

            // 1. 7문자씩 자르기
            String eachPw = pw.substring(7 * i, 7 * (i + 1));

            // 2. #를 1, *를 0으로
            eachPw = eachPw.replaceAll("#", "1");
            eachPw = eachPw.replaceAll("\\*", "0");

            // 3. parseInt 통해 문자열 2진수로 해석해 정수로 변환
            int code = Integer.parseInt(eachPw, 2);

            // 4. 3 결과 바탕으로 알파벳
            answer.append((char) code);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pw = br.readLine();
        System.out.println(solution(n, pw));
    }
}
