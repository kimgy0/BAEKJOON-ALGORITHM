package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_5 {
    public static void main(String[] args) throws IOException {
        int reverse = 0;
        int normal = 0;
        char temp;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toCharArray();

        reverse = chars.length - 1;

        while(reverse > normal){
            if(Character.isAlphabetic(chars[normal]) && Character.isAlphabetic(chars[reverse])){
                temp = chars[normal];
                chars[normal] = chars[reverse];
                chars[reverse] = temp;
                reverse--;
                normal++;
            }
            if(!Character.isAlphabetic(chars[normal])){
                normal++;
            }
            if(!Character.isAlphabetic(chars[reverse])){
                reverse--;
            }
        }

        System.out.println(String.valueOf(chars));



    }
}
