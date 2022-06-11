package purpleIIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 필수 테스트
 * 분기 숫자 구하기
 */
public class Solve_1 {

    public static int solve(int month){
        int x = (int) Math.ceil(month / (double)3);
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(bf.readLine());
        if(month > 12 || month < 1){
            return;
        }
        int x = solve(month);
        System.out.println(x);
    }
}
