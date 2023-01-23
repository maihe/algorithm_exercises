package com.maihe.algor.hackerrank.interview.sorting.marktoys;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class MarkToys {

    @ShellMethod("Mark Toys")
    public void markToys() throws IOException {
        try {
            System.out.println("Run - Mark Toys");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {


    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
      //  sortPrices(prices);
        prices = prices.stream().sorted().collect(toList());
        int totalSpent = 0;
        boolean isMaxReached = false;
        int totalToys = 0;
        for (int i = 0; !isMaxReached; i++){
            totalSpent += prices.get(i);
            if(totalSpent <= k) totalToys++;
            else isMaxReached = true;
        }
        return totalToys;

    }

    private static void sortPrices(List<Integer> prices){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < prices.size() - 1; i++) {
                if (prices.get(i) > prices.get(i + 1)) {
                    //swap elements
                    int temp = prices.get(i);
                    prices.set(i, prices.get(i + 1));
                    prices.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.maximumToys(prices, k);
        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

