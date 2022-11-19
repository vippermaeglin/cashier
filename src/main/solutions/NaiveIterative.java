package main.solutions;

import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class NaiveIterative {

    public static boolean canIGiveChange(Map<Integer, Integer> registerStatus, Integer customerPayment, Integer productCost) {

        int change = customerPayment - productCost;

        // optimization 1: remove zero bills from register
        registerStatus.values().removeIf(f -> f == 0);

        // optimization 2: iterate across the bills sorted descending
        SortedSet<Integer> billSortedDesc = new TreeSet(Collections.reverseOrder());
        billSortedDesc.addAll(registerStatus.keySet());

        for (int bill : billSortedDesc) {
            if (change >= bill && registerStatus.get(bill) > 0) {
                change = giveChange(change, registerStatus.get(bill), bill);
                if (change == 0) {
                    return true;
                }
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
