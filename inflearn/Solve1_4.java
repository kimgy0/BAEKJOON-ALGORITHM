package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *  또 다른 해결 방법
 *  String tmp = new StringBuilder(x) 를 적게되면 String 은 똑같은 String 이지만,
 *  x 에 대해 String 을 만들 뿐 아니라 String 을 다루는 메서드 여러개를 지원한다.
 *
 *  그 중 .reverse 함수가 존재한다.
 *  String tmp = new StringBuilder(x).reverse() -> 문자가 뒤집혀짐.
 *
 *   ***** Builder 사용 이유 *****
 *  String Builder 를 쓰는 이유는 일반 String 에 메서드를 사용하면 객체를 무한히 생성해서 그 작업을 진행한다.
 *  하지만 빌더는 객체를 따로 더 만들지 않고 연산을 실행한다.
 */
public class Solve1_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());

        List<String> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            char tmp;
            char[] chars = bf.readLine().toCharArray();
            for(int j = 0; j < chars.length / 2; j++){
                tmp = chars[j];
                chars[j] = chars[chars.length - j - 1];
                chars[chars.length - j - 1] = tmp;
            }
            list.add(String.valueOf(chars));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
