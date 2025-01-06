package section2_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class problem4_단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        for(int i=0;i<size;i++) {
            String input = reader.readLine();
            StringBuilder sb = new StringBuilder();

            for(int j=input.length()-1;j>=0;j--) {
                sb.append(input.charAt(j));
            }

            System.out.println(sb);
        }
    }
}
