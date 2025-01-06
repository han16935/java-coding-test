package section2_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem7_회문문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toLowerCase();
        int lt = 0;
        int rt = s.length() - 1;
        boolean isPalindrome = true;

        while(lt < rt) {
            if (s.charAt(lt) == s.charAt(rt)) {
                lt++;
                rt--;
            }

            else {
                System.out.println("NO");
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) System.out.println("YES");
        return ;
    }
}
