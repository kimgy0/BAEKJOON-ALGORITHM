package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon2580 {

    static int[][] sd = new int[9][9];
    static StringBuilder sb = new StringBuilder("");

    public static void recursive(int x, int y) {

        if (y == 9) {
            for (int[] ints : sd) {
                for (int anInt : ints) {
                    sb.append(anInt+" ");
                }
                sb.append("\n");
            }
            int i = sb.lastIndexOf("\n");
            sb.replace(i,sb.length(),"");
            System.out.print(sb);
            System.exit(0);
        }

        if (x == 9){
            recursive(0,y+1);
            return;
        }

        if(sd[y][x]==0){
            for(int i = 1; i < 10; i++){
                if(check(x,y,i)){
                    sd[y][x]=i;
                    recursive(x+1,y);
                }
            }
//            sd[y][x] = 0;
//            return;
        }
        recursive(x+1, y);
    }

    static boolean check(int x, int y, int i) {
        for(int j = 0; j < 9; j++){
            if(sd[y][j] == i){
                return false;
            }
        }

        for(int j = 0; j < 9; j++){
            if(sd[j][x]==i){
                return false;
            }
        }

        //start point
        int nx = x/3*3;
        int ny = y/3*3;

        for(int j = nx; j < nx+3; j++){
            for(int k = ny; k < ny+3; k++){
                if(sd[k][j]==i){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] s = bf.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                sd[i][j] = Integer.parseInt(s[j]);
            }
        }
        recursive(0,0);
    }
}
