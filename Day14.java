import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<String> sortedList = new ArrayList<String>();
        int i=0;
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            if(emailID.matches(".*@gmail.com.*")){
                sortedList.add(firstName);
            } 
        }
        String[] str =new String[sortedList.size()];
        str = sortedList.toArray(str);
        Arrays.sort(str);
        for(int j=0; j<str.length; j++){
            System.out.println(str[j]);
        }
        scanner.close();

    }
}
