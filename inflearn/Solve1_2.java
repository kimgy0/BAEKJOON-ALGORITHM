package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bf.readLine().toCharArray();
        
        for (int i = 0; i < input.length; i ++) {
            if(Character.isUpperCase(input[i])){
                input[i] = Character.toLowerCase(input[i]);
            }else{
                input[i] = Character.toUpperCase(input[i]);
            }
            System.out.print(input[i]);
        }
    }
}
