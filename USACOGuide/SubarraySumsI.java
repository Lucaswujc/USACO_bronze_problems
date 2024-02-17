package USACOGuide;

import java.util.*;
public class SubarraySumsI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scan.nextInt();;
        }
        int count = 0;
        int j = 0;
        int i = 0;
        int sum = 0;
        while(i <n){
            sum += arr[i];
            while(sum >= x){
                if(sum == x){
                    count++;
                }
                sum -= arr[j];
                j++;
            }
            i++;
        }
        System.out.println(count);
        scan.close();
    }
}