package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.company.Command.Hit;
import static com.company.Command.Stand;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        Table table = new Table();
        table.init();
        while(true) table.play();

    }
}