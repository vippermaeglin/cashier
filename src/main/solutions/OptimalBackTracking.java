package main.solutions;

import java.util.HashMap;
import java.util.Map;

public class OptimalBackTracking {

    /*
     * There are scenarios where a given bill may not lead to a feasible solution, it's the 4th and 5th test cases
     * Which means that we'll need to try all possible bill combinations until we match the change (or not)
     * This backtracking approach test all the possible bill permutations and remove those bills that won't lead to a solution
     * */
    public static boolean canIGiveChange(Map<Integer, Integer> registerStatus, Integer customerPayment, Integer productCost) {
        int change = customerPayment - productCost;
        return backTrack(change, registerStatus);
    }

    public static boolean backTrack(int change, Map<Integer, Integer> registerStatus) {

        // base case
        if (change == 0) {
            return true;
        }

        for (Map.Entry<Integer, Integer> bill : registerStatus.entrySet()) {
            if (change >= bill.getKey() && bill.getValue() > 0) {
                change -= bill.getKey();
                if (change == 0) {
                    return true;
                }
                Map<Integer, Integer> newRegister = copyAndRemove(registerStatus, bill.getKey());
                if (backTrack(change, newRegister)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper method to do a Map deep copy while removing a specific bill
    // by default java would create a shallow copy and also modify the original Map
    public static Map<Integer, Integer> copyAndRemove(Map<Integer, Integer> original, int removed) {
        Map<Integer, Integer> copy = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : original.entrySet()) {
            if (entry.getKey() == removed) {
                int value = entry.getValue().intValue() - 1;
                copy.put(entry.getKey(), value);
            } else {
                copy.put(entry.getKey(), entry.getValue().intValue());
            }
        }
        return copy;
    }
}
