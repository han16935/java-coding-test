package inflearn.section2_string;

import java.io.*;

public class problem10_가장짧은문자거리 {
    public static String solution(String s, char t) {
        StringBuilder answer = new StringBuilder();
        if (!s.contains(String.valueOf(t))) {
            for(int i=0;i<s.length() - 1;i++) {
                answer.append("0 ");
            }
            answer.append("0");
            return answer.toString();
        }

        int [] arr = new int[s.length()];

        for(int i=1;i<s.length();i++) {
            if (s.charAt(i) == t) {
                arr[0] = i;
                break;
            }
        }

        int ltMin = 0;
        boolean isLtIndexZero = false;
        int rtMin = 0;
        boolean isRtIndexZero = false;

        for(int j=1;j<arr.length;j++) {
            if (s.charAt(j) == t) continue;

            for (int k=j-1;k>=0;k--) {
                if (s.charAt(k) == t || arr[k] > 0) {
                    ltMin = j - k;
                    isLtIndexZero = s.charAt(k) == t;
                    break;
                }
            }

            for (int l=j+1;l<arr.length;l++) {
                if (s.charAt(l) == t || arr[l] > 0) {
                    rtMin = l - j;
                    isRtIndexZero = s.charAt(l) == t;
                    break;
                }
            }

            if (ltMin < rtMin) {
                if (isLtIndexZero) {
                    arr[j] = ltMin;
                    isLtIndexZero = false;
                }
                else arr[j] = ltMin + 1;
            }

            else {
                if (isRtIndexZero) {
                    arr[j] = rtMin;
                    isRtIndexZero = false;
                }
                else arr[j] = rtMin - 1;
            }
        }

        for(int m=0;m<arr.length-1;m++) {
            answer.append(arr[m] + " ");
        }
        answer.append(arr[arr.length-1]);
        return answer.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] arr = s.split(" ");
        System.out.println(solution(arr[0], arr[1].charAt(0)));
    }
}
