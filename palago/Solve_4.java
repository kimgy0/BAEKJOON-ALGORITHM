package palago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solve_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] num = bf.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);

        List<String> tables = new ArrayList<>();

        String[] hint = new String[m];

        String pw = bf.readLine();

        for(int i = 0; i < m; i++){
            hint[i] = bf.readLine();
        }

        // kmp 이동 테이블 값 받기
        for(int i = 0; i < m; i++){
            char[] chars = hint[i].toCharArray();
            int[] table = new int[chars.length];

            int k = 0;
            table[k] = 0;
            for(int j = 1; j < chars.length; j++) {
                while(k > 0 && chars[k] != chars[j]){
                    k = table[k-1];
                }
                if(chars[j] == chars[k]){
                    table[j] = ++k;
                }
            }
            for (int i1 : table) {
                System.out.println("i1 = " + i1);
            }
        }
        /**
         *  KMP 알고리즘을 이용해야 하는 문제의 의도는 알겠습니다만, 많이 접해보지 못한 알고리즘 응용 문제라
         *  풀지 못했습니다.
         */
    }
}
