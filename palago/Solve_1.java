package palago;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solve_1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // n 입력 받기
        int n = scanner.nextInt();
        /*
         * buffered reader 가 더 빠르고 좋지만,
         * 출력값에서 엔터와 스페이스를 동시에 요구하는 바가 있어서 scanner 로 진행하였습니다.
         */

        // 배열 입력 받기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        // 우선 해당 배열을 간단하게 정렬 후
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        // start 기준 인덱스
        int start = 0;


        boolean flag = false;

        // start 가 n-1 보다 작을 경우에만 돌립니다.
        //  -> for 내부에서 n+1 까지 돌리기 때문에 n-1 로 설정.
        while(n-1 > start){
            // 중복의 경우 flag 를 이용해 바뀌었다는 것을 표시합니다.
            // 한 부분의 중복체크가 끝나면 false 로 다시 설정해주어야합니다.
            flag = false;
            for(int i = start+1; i < n; i++){
                // start 와 그 다음 값부터 비교
                if(sorted[start] == sorted[i]){
                    // 같을 경우 기준 값이 아닌 다른 값을 범위 이외에 1001 로 변경
                    sorted[i] = 1001;
                    // 중복이라는 것을 나타내기 위해 flag 변수를 true 로 설정합니다.
                    flag = true;
                }else{
                    if(flag){
                        // 중복이 아닌 것을 만나고 else 를 타게되면 중복이 이전에 있었을 경우
                        // 기준점도 1001 로 바꾸어야하기 때문에 flag 를 사용해서 1001 로 기준값을 변경.
                        sorted[start] = 1001;
                    }
                    start = i;
                    // 그 다음이 중복이 아니라면 기준은 i (start + n)

                    // 그 다음 불필요한 스캔을 없애기 위해 break 로 탈출.
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : sorted) {
            if(i!=1001){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(" ")));
    }
}
