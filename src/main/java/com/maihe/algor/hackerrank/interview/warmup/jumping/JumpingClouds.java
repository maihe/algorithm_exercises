package com.maihe.algor.hackerrank.interview.warmup.jumping;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class JumpingClouds {

    @ShellMethod("Jumping on Clouds")
    public void jumpingClouds() throws IOException {
        try {
            System.out.println("Run - Jumping on Clouds");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    // 0 1 2 3 4 5 6
    // 0 1 0 0 0 1 0
    //return the shorter
    // jump +1 or +2
    public static int jumpingOnClouds(List<Integer> clouds) {

        final int dj = 2;
        final int sj = 1;
        int pathLength = 0;
        for (int i=0; i < clouds.size();) {
            if((i < clouds.size()-dj) && clouds.get(i+dj) == 0){
                i+=2;
                pathLength++;
            } else if((i < clouds.size()-sj) && clouds.get(i+sj) == 0){
                i++;
                pathLength++;
            } else {
                System.out.print("End of possibilities");
                System.out.print("" + clouds);
                break;
            }
        }
        return pathLength;
    }


}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

