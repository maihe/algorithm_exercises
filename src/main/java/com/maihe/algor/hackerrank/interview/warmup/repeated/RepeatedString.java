package com.maihe.algor.hackerrank.interview.warmup.repeated;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

import java.io.*;

@ShellComponent
public class RepeatedString {

    @ShellMethod("Repeated Strings")
    public void repeatedStrings() throws IOException {
        try {
            System.out.println("Run Repeated Strings");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String str, long n) {
        final String substring = "a";
        long totalOccurrences = findOccurrences(str, substring);
        long multiplier;
        if (n >= str.length()){
            multiplier = n/str.length();
            totalOccurrences*=multiplier;
            int diff = (int)(n - (multiplier * str.length()));
            totalOccurrences += findOccurrences(str.substring(0, diff) , substring);

        } else {
            totalOccurrences = findOccurrences(str.substring(0, Math.toIntExact(n)),substring);
        }
        System.out.println("fixed totalOccurrences " + totalOccurrences);

        return totalOccurrences;
    }

    private static long findOccurrences(String str, String substring){
        long count = 0;
        int fromIndex = 0;

        while (fromIndex != -1){
            fromIndex = str.indexOf(substring);
            if(fromIndex != -1){
                str = str.substring(fromIndex+1);
                count++;
            }
        }
        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine().trim());
        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

