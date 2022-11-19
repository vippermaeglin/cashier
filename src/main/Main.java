package main;

import main.solutions.OptimalBackTracking;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> registerStatus = new HashMap<>();
        registerStatus.put(1, 30); // One Dolar, 30 bills;
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 3); // Five Dolar, 3 bills;
        registerStatus.put(10, 2); // Ten Dolar, 2 bills;
        registerStatus.put(20, 1); // Ten Dolar, 2 bills;
        registerStatus.put(50, 1); // Ten Dolar, 2 bills;
        registerStatus.put(100, 0); // Ten Dolar, 2 bills;

        // First approach - brute force
        //boolean result = NaiveBruteForce.canIGiveChange(registerStatus, 100, 9);

        // Second approach - iterative (brute force refactored)
        //boolean result = NaiveIterative.canIGiveChange(registerStatus, 100, 9);

        // Final approach - backtracking
        boolean result = OptimalBackTracking.canIGiveChange(registerStatus, 100, 9);

        System.out.println("Result " + result);
    }

}
