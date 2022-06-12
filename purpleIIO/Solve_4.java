package purpleIIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 필수 테스트
 * 더하고 빼기
 */
public class Solve_4 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int num = Integer.parseInt(s);
        if(num<10 || num>10000){
            return;
        }
        num = solve(num);
        while(num>100){
            num = solve(num);
        }
        System.out.println("apple");
    }

    private static int solve(int num) {
        char[] numChar = String.valueOf(num).toCharArray();
        int[] numArr = new int[numChar.length];
        for (int i = 0; i < numChar.length; i++) {
            numArr[i] = Character.getNumericValue(numChar[i]);
        }

        int hap = 0;
        for (int i : numArr) {
            hap+=i;
        }
        num -= hap;
        return num;
    }
}
