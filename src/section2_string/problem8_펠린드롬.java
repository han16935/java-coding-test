package section2_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class problem8_펠린드롬 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().toLowerCase().replaceAll("[^a-z]", "");
        String tmp = new StringBuilder(line).reverse().toString();
        boolean result = line.equals(tmp);
        System.out.println(result ? "YES" : "NO");
    }
}
