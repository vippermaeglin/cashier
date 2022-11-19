package main.solutions;

import java.util.Map;

public class NaiveBruteForce {

    public static boolean canIGiveChange(Map<Integer, Integer> registerStatus, Integer customerPayment, Integer productCost) {

        int change = customerPayment - productCost;

        // 100
        if (change >= 100 && registerStatus.get(100) > 0) {
            change = giveChange(change, registerStatus.get(100), 100);
            if (change == 0) {
                return true;
            }
        }
        // 50
        if (change >= 50 && registerStatus.get(50) > 0) {
            change = giveChange(change, registerStatus.get(50), 50);
            if (change == 0) {
                return true;
            }
        }
        // 20
        if (change >= 20 && registerStatus.get(20) > 0) {
            change = giveChange(change, registerStatus.get(20), 20);
            if (change == 0) {
                return true;
            }
        }
        // 10
        if (change >= 10 && registerStatus.get(10) > 0) {
            change = giveChange(change, registerStatus.get(10), 10);
            if (change == 0) {
                return true;
            }
        }
        // 5
        if (change >= 5 && registerStatus.get(5) > 0) {
            change = giveChange(change, registerStatus.get(5), 5);
            if (change == 0) {
                return true;
            }
        }
        // 2
        if (change >= 2 && registerStatus.get(2) > 0) {
            change = giveChange(change, registerStatus.get(2), 2);
            if (change == 0) {
                return true;
            }
        }
        // 1
        if (change >= 1 && registerStatus.get(1) > 0) {
            change = giveChange(change, registerStatus.get(1), 1);
            if (change == 0) {
                return true;
            }
        }

        return false;
    }

    public static int giveChange(int change, int bills, int billValue) {
        while (bills > 0 && change >= billValue) {
            change -= billValue;
            bills--;
        }
        return change;
    }
}
