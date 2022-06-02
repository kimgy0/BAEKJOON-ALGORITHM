package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toUpperCase().toCharArray();

        boolean flag = true;

        for (int i = 0; i < chars.length / 2; i ++){
            if(chars[i] != chars[chars.length - i - 1]){
                flag = false;
            }
        }
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
