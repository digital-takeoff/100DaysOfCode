import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int[] arr = new int[s];
        for(int i = 0 ; i < s ; i++){
            arr[i] = scan.nextInt();
        }
        for(int i=0 ;i<s;i++){
           int n = arr[i];
            if(n!=1){
                int j=2;
                boolean c =true;
                while (j*j<=n){
                    if(n%j==0){
                        System.out.println("Not prime");
                        c=false;
                        break;
                    }
                    j++;
                }
                if(c){
                    System.out.println("Prime");
                }
            }else{
                System.out.println("Not prime");
            }
        }
    
    }
}
