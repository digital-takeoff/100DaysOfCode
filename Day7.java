import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int bsearch(int[] a,int s,int st,int e){
        if(e-st<=1 ){
            return e;
        }else if(a[e-1]==s){
            return e-1;
        }else if(a[st]==s){
            return st;
        }else if(a[st]<s){
            return st;
        }else if(a[e-1]>s){
            return e;
        }else if(a[(st+e)/2] < s && s < a[st]){
            return bsearch(a,s,st,((st+e)/2));
        }else{
            return bsearch(a,s,((st+e)/2),e);
        }
    }
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int rank = scores.length;
        int[] rk= new int[alice.length];
        if(rank>0){
            int prev = scores[0];
            int diff=0;
            int[] ranks = new int [scores.length];
            for(int i = 1 ; i<scores.length ; i++){
                ranks[i-1]=i-diff;
                if(prev==scores[i]){
                  diff++;  
                }
                prev = scores[i];
            }
            ranks[scores.length-1]=scores.length-diff;
            System.out.println(Arrays.toString(ranks));
            for (int i=0 ;i<alice.length;i++){
                if(alice[i]>=scores[0]){
                    rk[i]=1;
                }else if(alice[i]<scores[scores.length-1]){
                    rk[i]= ranks[scores.length-1]+1 ;
                }else{
                    rk[i]=ranks[bsearch(scores,alice[i],0,scores.length)];
                }
            }
            return rk;
        }else{
            return rk;
        } 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
