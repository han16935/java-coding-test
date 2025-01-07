package section2_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class problem8_펠린드롬 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine().toLowerCase();
        line = line.replaceAll("[^a-z]", "");
        int lt = 0;
        int rt = line.length() - 1;
        boolean result = true;

        while (lt < rt) {
            if (line.charAt(lt) != line.charAt(rt)) {
                result = false;
                break;
            }
            lt++;
            rt--;
        }

        System.out.println(result ? "YES" : "NO");
    }
}
