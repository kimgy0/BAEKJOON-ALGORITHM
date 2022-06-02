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
            /**
             *  아스키코드로 하는 방법
             *  A -> 65 ~ 90
             *  a -> 97 ~ 122
             *
             *  소문자 아스키에 32 를 빼면 소문자 아스키 값이 출력된다.
             *  자료형은 (char) 로 묶어주자.
             */
            System.out.print(input[i]);
        }
    }
}
