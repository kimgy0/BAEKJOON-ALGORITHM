package purpleIIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 필수 테스트
 * 사용하지 않는 가장 작은 숫자 찾기
 */
public class Solve_2 {

    private static int min;

    public static int solve(int[] ids, int start, int length){
        int mid = (length + start) / 2;

        if(start + 1 == length){
            if(ids[start] == start && ids[length] == length){
                return ids[length] + 1;
            }
            if(ids[start] == start && ids[length] != length){
                return start + 1;
            }
            if(ids[start] != start && ids[length] != length){
                return 0;
            }
        }

        if(ids[mid] == mid){
            return solve(ids, mid, length);
        }
        if(ids[mid] != mid){
            return solve(ids, start, mid);
        }
        return 999;
    }

    public static void sort(int[] ids,int start, int end) {
        int part = divide(ids, start, end);
        if(start < part-1){
            sort(ids, start,part-1);
        }
        if(part < end){
            sort(ids, part, end);
        }
    }

    public static int divide(int[] ids,int start,int end) {
        int pivot = ids[(start + end) / 2];
        while(start <= end) {

            while(ids[start]<pivot){
                start++;
            }
            while(ids[end]>pivot){
                end--;
            }
            if(start<=end) {

                int temp=ids[start];
                ids[start]=ids[end];
                ids[end]=temp;

                start++;
                end--;
            }
        }
        return start;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().replace("[", "").replace("]", "").split(",");
        int[] arr = new int[split.length];

        for(int i = 0; i < split.length; i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        sort(arr, 0, arr.length - 1);
        
        System.out.println(solve(arr,0,arr.length - 1));
    }
}
