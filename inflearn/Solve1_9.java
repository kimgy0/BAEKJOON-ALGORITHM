package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_9 {
    /**
     * int answer = 0
     * for -> char x : str
     *
     * ascii 넘버로도 가능 -> if(x>=48 && x<=57) answer=answer * 10 + (x-48);
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().replaceAll("[^0-9]", "");
        int i = Integer.parseInt(s.equals("")? "0" : s);
        System.out.println(i);
    }
}
