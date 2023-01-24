package com.maihe.algor.hackerrank.interview.sorting.comparator;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ShellComponent
public class ComparatorTest {

    @ShellMethod("Comparator")
    public void comparator() throws IOException {
        try {
            System.out.println("Run - Comparator");
            Solution.main(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        return a.score == b.score ? compareName(a, b): compareScore(a, b);
    }

    private int compareScore(Player a, Player b){
        return Integer.compare(b.score,a.score);
    }
    private int compareName(Player a, Player b){
        return a.name.compareTo(b.name);
    }
}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("response"));

        int n = Integer.parseInt(bufferedReader.readLine());
        Player[] player = new Player[n];
        Checker checker = new Checker();

        List<String> inputLines = bufferedReader.lines().collect(toList());

        for(int i = 0; i < n; i++){
            String[] line = inputLines.get(i).split(" ");
            player[i] = new Player(line[0], Integer.parseInt(line[1]));
        }

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
        //bufferedWriter.write(String.valueOf(result));

        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

