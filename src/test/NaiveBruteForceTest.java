package test;

import main.solutions.NaiveBruteForce;
import main.solutions.OptimalBackTracking;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NaiveBruteForceTest {

    @Test
    void testCaseOne() {

        // Arrange
        Map<Integer, Integer> registerStatus = Map.of(1, 0, 2, 0, 5, 3, 10, 0);
        int customerPayment = 20;
        int productCost = 5;

        // Act
        boolean result = NaiveBruteForce.canIGiveChange(registerStatus, customerPayment, productCost);

        // Assert
        assertTrue(result);
    }

    @Test
    void testCaseTwo() {

        // Arrange
        Map<Integer, Integer> registerStatus = Map.of(1, 3, 2, 3, 5, 3, 10, 0, 20, 0, 50, 1, 100, 1);
        int customerPayment = 60;
        int productCost = 2;

        // Act
        boolean result = NaiveBruteForce.canIGiveChange(registerStatus, customerPayment, productCost);

        // Assert
        assertTrue(result);
    }

    @Test
    void testCaseThree() {

        // Arrange
        Map<Integer, Integer> registerStatus = Map.of(1, 0, 2, 0, 5, 3, 10, 0, 50, 1);
        int customerPayment = 60;
        int productCost = 2;

        // Act
        boolean result = NaiveBruteForce.canIGiveChange(registerStatus, customerPayment, productCost);

        // Assert
        assertFalse(result);
    }

    // The original 4th test case was the same as above so I modified it
    // Edge scenario: Change is $6 and the $5 bill is available, but it should be skipped since it won't lead to a solution
    // PS: this scenario is supposed to fail for this algorithm, the backtracking optimal solution fixed it
    @Disabled
    @Test
    void testCaseFour() {

        // Arrange
        Map<Integer, Integer> registerStatus = new HashMap<>();
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 1); // Five Dolar, 1 bill;
        int customerPayment = 10;
        int productCost = 4;

        // Act
        boolean result = NaiveBruteForce.canIGiveChange(registerStatus, customerPayment, productCost);

        // Assert
        assertTrue(result);

    }

    // Edge scenario: Change is $11 and we should use only one %5 bill (and skip the other one), handling any kind of permutations
    // PS: this scenario is supposed to fail for this algorithm, the backtracking optimal solution fixed it
    @Disabled
    @Test
    void testCaseFive() {

        // Arrange
        Map<Integer, Integer> registerStatus = new HashMap<>();
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 2); // Five Dolar, 2 bills;
        int customerPayment = 15;
        int productCost = 4;

        // Act
        boolean result = OptimalBackTracking.canIGiveChange(registerStatus, customerPayment, productCost);

        // Assert
        assertTrue(result);

    }
}
