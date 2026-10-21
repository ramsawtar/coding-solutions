# Extra Long Factorials

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The *factorial* of the integer $n$, written $n!$, is defined as:   

$$n! = n \times (n-1) \times (n-2) \times \cdots \times 3 \times 2 \times 1$$

Calculate and print the factorial of a given integer.  

For example, if $n = 30$, we calculate $30 \times 29 \times 28 \times \cdots \times 2 \times 1$ and get $265252859812191058636308480000000$.

**Function Description**

Complete the *extraLongFactorials* function in the editor below.  It should print the result and return.  

extraLongFactorials has the following parameter(s):  

- *n*: an integer

**Note:** Factorials of $n > 20$ can't be stored even in a $64-bit$ long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.  

We recommend solving this challenge using BigIntegers.  

**Input Format**

 Input consists of a single integer $n$

**Constraints**

$1 \le n \le 100$

**Output Format**

Print the factorial of $n$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T17:51:37.785Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
    BigInteger factorial = BigInteger.ONE;
    
    for (int i = 1; i <= n; i++) {
        factorial = factorial.multiply(BigInteger.valueOf(i));
    }
    
    System.out.println(factorial.toString());
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/extra-long-factorials/problem)