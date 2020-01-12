package com.ucakturk.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class StackTransaction {

    private Map<Integer, Stack<Integer>> mapOfTransactions = new HashMap<>();
    private int countOfTransactions = 0;

    public StackTransaction() {
        Stack<Integer> stack = new Stack<>();
        mapOfTransactions.put(countOfTransactions, stack);
    }

    public void push(int value) {
        mapOfTransactions.get(countOfTransactions).push(value);
    }

    public int top() {
        if (mapOfTransactions.get(countOfTransactions).isEmpty()) {
            return 0;
        }
        return mapOfTransactions.get(countOfTransactions).peek();
    }

    public void pop() {
        if (mapOfTransactions.get(countOfTransactions).isEmpty()) {
            return;
        }
        mapOfTransactions.get(countOfTransactions).pop();
    }

    public void begin() {
        Stack<Integer> newStack = (Stack<Integer>) mapOfTransactions.get(countOfTransactions).clone();
        countOfTransactions++;
        mapOfTransactions.put(countOfTransactions, newStack);
    }

    public boolean rollback() {
        if (mapOfTransactions.size() == 1) {
            return false;
        }
        mapOfTransactions.remove(countOfTransactions);
        countOfTransactions--;
        return true;
    }

    public boolean commit() {
        if (mapOfTransactions.size() == 1) {
            return false;
        }
        if (mapOfTransactions.size() == 2) {
            mapOfTransactions.remove(1);
            return true;
        }
        Stack<Integer> lastTransaction = mapOfTransactions.remove(countOfTransactions);
        countOfTransactions--;
        mapOfTransactions.replace(countOfTransactions, lastTransaction);
        return true;
    }

    public static void main(String[] args) {
        //test1
        StackTransaction sol = new StackTransaction();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";
        System.out.println(sol.top() == 42);
        sol.push(22);
        System.out.println(sol.top() == 22);
        sol.pop();
        System.out.println(sol.top() == 42);
        StackTransaction sol2 = new StackTransaction();
        System.out.println(sol2.top() == 0);
        sol2.pop();

        StackTransaction sol3 = new StackTransaction();
        sol3.push(4);
        sol3.begin();
        sol3.push(7);
        sol3.begin();
        sol3.push(2);
        System.out.println(sol3.rollback());
        System.out.println(sol3.top() == 7);
        sol3.begin();
        sol3.push(10);
        System.out.println(sol3.commit());
        System.out.println(sol3.top() == 10);
        System.out.println(sol3.rollback());
        System.out.println(sol3.top() == 4);
        System.out.println(sol3.commit());
    }

}