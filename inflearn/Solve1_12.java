package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 여기서 핵심은 replace , parseInt(string, [2,8,16])
 */
public class Solve1_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());

        String s = bf.readLine();

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++){
            String replace = s.substring(i * 7, (i * 7) + 7).replace('*', '0').replace('#', '1');
            char c = (char) Integer.parseInt(replace, 2);
            sb.append(c);
        }

        System.out.println(sb);
    }
}
