package com.ucakturk.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class HashSet {


    public static void main(String[] args) {
        Set<String> set = new java.util.HashSet<>();


        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        for (int i = 0; i < pair_left.length; i++) {
            set.add(pair_left[i].concat(pair_right[i]));
            System.out.println(set.size());

        }
    }

    void calculate() {
        try {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y == 0)
                throw new ArithmeticException("/ by zero");
            else
                System.out.println(x / y);
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
