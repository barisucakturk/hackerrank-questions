package com.ucakturk.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FindLargestNonnegativeNumberThatDoesntExist {

    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> sortedNonNegativeList =
            Arrays.stream(A).boxed().filter(integer -> integer > 0).sorted().collect(Collectors.toList());
        int result = 1;
        for (Integer element : sortedNonNegativeList) {
            if (element == result) {
                result++;
            } else if (element > result) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 3, 3, 3, 4, 5, 5, 5, 5 };
        FindLargestNonnegativeNumberThatDoesntExist test = new FindLargestNonnegativeNumberThatDoesntExist();
        System.out.println(test.solution(a));
    }
}
