package com.maihe.algor.hackerrank.interview.warmup.countvalleys;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;

@ShellComponent
public class CountValleys {

    @ShellMethod("Count Valleys")
    public void countValleys() throws IOException {
        try {
            System.out.println("Run - Count Valleys");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {

        // nivel do mar = 0
        // laco for each index da string
        // increment current level at each char
        if(steps != path.length()) return -1;
        int currentLevel = 0;
        int totalValleys = 0;
        path.chars().forEach(step ->{
        });
        for (char step : path.toCharArray()) {
            if(step == 'D'){
                currentLevel--;
            }
            if(step == 'U'){
                currentLevel++;
                if(currentLevel == 0){
                    totalValleys++;
                }
            }
        }

        return totalValleys;

    }


}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

