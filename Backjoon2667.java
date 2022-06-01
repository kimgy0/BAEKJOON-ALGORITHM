import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Backjoon2667 {

    static int size;
    static boolean[][] visit;
    static int[][] array;
    static int count = 0;
    static List<Integer> area = new ArrayList<>();
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());

        visit = new boolean[size][size];
        for (boolean[] booleans : visit) {
            Arrays.fill(booleans, false);
        }

        array = new int[size][size];

        for(int h = 0; h < size; h++){
            String s = bf.readLine();
            String[] split = s.split("");
            for(int w = 0; w < size; w++){
                array[h][w]= Integer.parseInt(split[w]);
            }
        }

        for(int h = 0; h < size; h++){
            for(int w = 0; w < size; w++){
                if(array[h][w]==1 && visit[h][w]==false){
                    recursiveDfs(h,w);

                    // 끝나면 증가된 count 로 그림의 크기를 area 리스트에 추가함.
                    if(count != 0){
                        area.add(count);
                        count = 0;
                    }
                    // 다음 그림을 위해서 count 는 0으로 초기화함.
                }
            }
        }
        System.out.println(area.size());
        Collections.sort(area);
        for (int i = 0; i < area.size(); i++) {
            System.out.println(area.get(i));
        }
    }

    public static void recursiveDfs(int h, int w){
        visit[h][w] = true;
        count++;

        for (int i = 0; i < 4; i++){
            int nx = h + dx[i]; // { 0, 1, 0, -1 }
            int ny = w + dy[i]; // { 1, 0, -1, 0 } 이렇게 증가한 좌표들에 한함.
            if(nx >= 0 && ny >= 0 && nx < size && ny < size){ // 리스트 범위 체크
                if (array[nx][ny] == 1 && visit[nx][ny] == false) { // 4방향으로 증가한 좌표값이 1이며 방문하지 않았을 때 재귀 진행.
                    recursiveDfs(nx,ny); // nx, ny 를 넘겨주면 또 그 안에서 방향 증가시키고 재귀함.
                }
            }
        }
        // 4 방으로 재귀가 끝나게 되면 recursive 가 끝남.
    }
}
