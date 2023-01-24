package com.maihe.algor.hackerrank.interview.sorting.fraudnotifications;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class FraudNotifications {

    @ShellMethod("Fraud Notifications")
    public void fraudNotifications() throws IOException {
        try {
            System.out.println("Run - Fraud Notifications");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Result {
    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int totalNotifications = 0;

        for (int i=d, j=0; i < expenditure.size(); i++){
            if(i >= d){
                List<Integer> periodExpenses = expenditure.subList(j, j+d).stream().sorted().collect(toList());
                double median = getMedian(periodExpenses);
                if(expenditure.get(i) >= median*2){
                    totalNotifications++;
                    System.out.println("Send notification");
                }
                j++;
            }

        }
        return totalNotifications;
    }

    private static double getMedian(List<Integer> periodExpenses) {
        double median = 0;
        int size = periodExpenses.size();
        if (size % 2 == 0) {
            median = (periodExpenses.get(size / 2 - 1) + periodExpenses.get(size / 2)) / 2.0;
        } else {
            median = periodExpenses.get(size / 2);
        }

        return median;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

