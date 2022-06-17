package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 문제 -> 아이디어는 점화식을 구하는 것이 가장 중요하다.
 *
 * 2xn 타일에서 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 */
public class Backjoon11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] rs = new int[n+1];
        // rs 에는 해당 n 값에 대해서 경우의 수를 정한다.
        // 예를 들어 2x2 일 때, 2가지 경우의 수가 존재하니까 rs[2] 에는 2를 저장한다.

        rs[0] = 0;
        // rs 0번 인덱스에는 2x0 일때는 칸이 없으니까 0을 저장
        rs[1] = 1;
        // rs 1번은 2x1 칸에 대해 블록이 들어갈 수 있는 경우의 수이니까 1가지가 존재한다.
        rs[2] = 2;
        // rs 2번은 2x2 칸에 대해 블록이 들어갈 수 있는 경우의 수이니까 2가지가 존재한다.

        for(int i = 3; i < n+1; i ++){
            rs[i] = (rs[i-1] + rs[i-2])%10007;
        }
        // rs 3번은 2x3 칸에 대해 블록이 들어갈 수 있는 경우의 수이니까 3가지가 존재한다.
        // 즉, 이전값과 이전 이전 값을 더해서 저장.
        // 그러면 1, 2 는 for 로 적용이 되지 않으며 점화식은 A(N) = A(n-1) + A(n-2)

        System.out.println(rs[n]);

    }
}
