
<h1 align="center">

  <br>
  <a><img src="https://www.clipartmax.com/png/small/40-409373_cash-register-clip-art-download-cartoon-cashier.png" alt="Cash Register Clip Art Download - Cartoon Cashier @clipartmax.com">
</a>
  <br>
  Cashier
  <br>
</h1>


## Problem
We need to create an intelligent register machine. It will check if it's possible to return a perfect money change with our money. First, you will need to create a method with three inputs.

1) The customer's Payment.
2) The product's price.
2) The cash register status, a Map<Integer, Integer>. The key is the bill value, and the value is how much you have.

For example:

If the customer pays $100, the item costs $1; we will need to return $99. The method will search in the register status whether we have 99 dollars.

## Conditions:
To simplify the problem:
* The register will work with $1, $2, $5, $10, $20, $50, and $100 bills no coins.

* The payment and the item cost are integers, not negative.

* The map can contain just one of the bills or all of them.

* The bill quantity will be a zero to a positive value.

To add complexity:

* The map can contain just one of the bills or many of them. For example:
```bash
 Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
 registerStatus.put(5, 3); // Five Dolar, 3 bills;
 ``` 

* The Bill count can be 0, For example:
```bash
 Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
 registerStatus.put(1, 0); // One Dolar, 0 bills;
 registerStatus.put(2, 0); // Two Dolar, 0 bills;
 registerStatus.put(5, 0); // Five Dolar, 0 bills;
 registerStatus.put(10, 0); // Ten Dolar, 0 bills;
```      

## Code Example:
```bash

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String ... args) {
        Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 30); // One Dolar, 30 bills;
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 3); // Five Dolar, 3 bills;
        registerStatus.put(10, 2); // Ten Dolar, 2 bills;
        registerStatus.put(20, 1); // Twenty Dolar, 2 bills;
        registerStatus.put(50, 0); // Fifty Dolar, 2 bills;
        registerStatus.put(100, 0); // Hundred Dolar, 2 bills;

        boolean result = canIGiveChange(registerStatus, 100, 9);
        System.out.printf("Result " + result);

    }

    public static boolean canIGiveChange(Map<Integer,Integer> registerStatus, Integer customerPayment, Integer productCost) {
        return false;
    }

}

```

## Test Cases:
### 1)
#### registerStatus:
```bash
Map: 
 Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
 registerStatus.put(1, 0); // One Dolar, 0 bills;
 registerStatus.put(2, 0); // Two Dolar, 0 bills;
 registerStatus.put(5, 3); // Five Dolar, 3 bills;
 registerStatus.put(10, 0); // Ten Dolar, 0 bills;
 ``` 
#### customerPayment: 20
#### productCost: 5

### return: TRUE

### 2)
#### registerStatus:
```bash
Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 3); 
        registerStatus.put(2, 3);
        registerStatus.put(5, 3);
        registerStatus.put(10, 0);
        registerStatus.put(20, 0);
        registerStatus.put(50, 1);
        registerStatus.put(100, 1); 
 ``` 
#### customerPayment: 60
#### productCost: 2

### return: TRUE

### 3)
#### registerStatus:
```bash
Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 0); 
        registerStatus.put(2, 0);
        registerStatus.put(5, 3);
        registerStatus.put(10, 0);
        registerStatus.put(50, 1);
 ``` 
#### customerPayment: 60
#### productCost: 2

### return: FALSE

### 4)
#### registerStatus:
```bash
Map<Integer, Integer> registerStatus = new HashMap<>();
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 1); // Five Dolar, 1 bill;
 ``` 
#### customerPayment: 10
#### productCost: 4

### return: TRUE

### 5)
#### registerStatus:
```bash
Map<Integer, Integer> registerStatus = new HashMap<>();
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 2); // Five Dolar, 2 bills;
 ``` 
#### customerPayment: 15
#### productCost: 4

### return: TRUE 
