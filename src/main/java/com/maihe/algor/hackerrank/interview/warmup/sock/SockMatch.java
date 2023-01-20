package com.maihe.algor.hackerrank.interview.warmup.sock;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class SockMatch {

    @ShellMethod("Sales by Match")
    public void sockMatch() throws IOException {
        try {
            System.out.println("Run - Sales by Match");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> list) {
        if(n < list.size()){
            System.out.println("N is less then t he size of the array");
        }
        HashSet<Integer> unmatched = new HashSet<>();
        int pairs = 0;
        for(int i = 0; i < list.size(); i++) {
            if(!unmatched.add(list.get(i))) {
                unmatched.remove(list.get(i));
                pairs++;
            }
        }

        return pairs;
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

