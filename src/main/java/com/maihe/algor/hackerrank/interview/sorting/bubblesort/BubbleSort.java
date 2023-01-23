package com.maihe.algor.hackerrank.interview.sorting.bubblesort;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class BubbleSort {

    @ShellMethod("Print Bubble Sort")
    public void printBubbleSort() throws IOException {
        try {
            System.out.println("Run - Bubble Sort");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> list) {
        int totalSwaps = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    //swap elements
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    totalSwaps++;
                    isSorted = false;
                }
            }
        }
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + list.get(0));
        System.out.println("Last Element: " + list.get(list.size()-1));

    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countSwaps(a);

        bufferedWriter.write(String.valueOf(0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

