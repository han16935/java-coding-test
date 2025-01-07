package section2_string;

import java.io.*;

public class problem9_숫자만추출 {

    static int solution(String str) {
        str = str.toLowerCase().replaceAll("[a-z]", "");
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
