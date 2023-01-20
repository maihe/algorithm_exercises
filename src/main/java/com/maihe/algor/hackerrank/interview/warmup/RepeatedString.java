package com.maihe.algor.hackerrank.interview.warmup;

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
        System.out.println("N "+ n +" STR " + str);
        long totalOcurrences = findOccurrences(str, substring);
        System.out.println("As in base String " + totalOcurrences);
        long multiplier;
        if (n >= str.length()){
            System.out.println("N >= than string -> multiply it ");
            multiplier = n/str.length();
            System.out.println("n/str.length() " + multiplier);

            totalOcurrences*=multiplier;
            System.out.println("totalOcurrences " + totalOcurrences);
            int diff = (int)(n - (multiplier * str.length()));
            totalOcurrences += findOccurrences(str.substring(0, diff) , substring);
        }// else {
        //    System.out.print("N < than string -> crop it");

        // }
        return totalOcurrences;
    }

    private static long findOccurrences(String str, String substring){
        System.out.println("find A's in str " + str);
        long count = 0;
        int fromIndex = 0;

        while (fromIndex < str.length()){
            fromIndex = str.indexOf(substring, fromIndex);
            if(fromIndex != -1){
                str = str.substring(fromIndex);
                count++;
                fromIndex++;
            } else { break; }


        }
        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("main");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
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

