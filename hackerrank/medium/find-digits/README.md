# Find Digits

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An integer $d$ is a *divisor* of an integer $n$ if the remainder of $n \div d = 0$.  

Given an integer, for each digit that makes up the integer determine whether it is a divisor.  Count the number of divisors occurring within the integer.  

**Example**  
$n = 124$  

Check whether $1$, $2$ and $4$ are divisors of $124$.  All 3 numbers divide evenly into $124$ so return $3$.  

$n = 111$  

Check whether $1$, $1$, and $1$ are divisors of $111$.  All 3 numbers divide evenly into $111$ so return $3$.  

$n = 10$  

Check whether $1$ and $0$ are divisors of $10$.  $1$ is, but $0$ is not.  Return $1$.  

**Function Description**

Complete the *findDigits* function in the editor below.   

findDigits has the following parameter(s):

- *int n*: the value to analyze  

**Returns**  

- *int:* the number of digits in $n$ that are divisors of $n$  

**Input Format**

The first line is an integer, $t$, the number of test cases.		
The $t$ subsequent lines each contain an integer, $n$.  



**Constraints**

$1 \le t \le 15$  
$0 < n < 10^{9}$

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-20T15:54:42.558Z  

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
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
    // Write your code here
    int count = 0;
    int original = n;
    
    while (n > 0) {
        int digit = n % 10;
        // Check if digit is not 0 and divides original evenly
        if (digit != 0 && original % digit == 0) {
            count++;
        }
        n /= 10;
    }
    
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/find-digits/problem)