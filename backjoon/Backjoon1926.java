package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1926 {

    static class Pair{

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        int max = 0;
        int count = 0;
        int area = 0;

        Queue<Pair> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);

        boolean[][] visit = new boolean[height][width];
        for (boolean[] booleans : visit) {
            Arrays.fill(booleans,Boolean.FALSE);
        }

        int[][] list = new int[height][width];
        for(int h = 0; h < height; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                list[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        for(int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (list[h][w] == 1 && visit[h][w] == false) {
                    count++;
                    queue.offer(new Pair(w, h));
                    visit[h][w] = true;
                    max++;

                    while(!queue.isEmpty()){
                        Pair p = queue.poll();
                        if(p.x + 1 < width && visit[p.y][p.x + 1] == false) {
                            visit[p.y][p.x + 1] = true;
                            if (list[p.y][p.x + 1] == 1) {
                                queue.offer(new Pair(p.x + 1, p.y));
                                max++;
                            }
                        }
                        if(p.x - 1 >= 0 && visit[p.y][p.x - 1] == false){
                            visit[p.y][p.x - 1] = true;
                            if(list[p.y][p.x - 1] == 1){
                                queue.offer(new Pair(p.x-1,p.y));
                                max++;
                            }
                        }
                        if(p.y + 1 < height && visit[p.y+1][p.x] == false) {
                            visit[p.y + 1][p.x] = true;
                            if (list[p.y + 1][p.x] == 1) {
                                queue.offer(new Pair(p.x, p.y + 1));
                                max++;
                            }
                        }
                        if(p.y - 1 >= 0 && visit[p.y-1][p.x] == false){
                            visit[p.y-1][p.x] = true;
                            if(list[p.y-1][p.x] == 1){
                                queue.offer(new Pair(p.x,p.y-1));
                                max++;
                            }
                        }
                    }
                    if(max > area){
                        area = max;
                    }
                    max=0;
                }
            }
        }
        System.out.println(count);
        System.out.println(area);
    }
}
