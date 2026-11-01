# Sherlock and Squares

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Watson likes to challenge Sherlock's math ability.  He will provide a starting and ending value that describe a range of integers, inclusive of the endpoints.  Sherlock must determine the number of *square integers* within that range.

**Note**: A square integer is an integer which is the square of an integer, e.g. $1, 4, 9, 16, 25$. 

**Example**  
$a = 24$  
$b = 49$  

There are three square integers in the range: $25, 36$ and $49$.  Return $3$.   

**Function Description**

Complete the *squares* function in the editor below.  It should return an integer representing the number of square integers in the inclusive range from $a$ to $b$.  

squares has the following parameter(s):  

- *int a:* the lower range boundary
- *int b:* the upper range boundary  

**Returns**  

- *int:* the number of square integers in the range

**Input Format**

The first line contains $q$, the number of test cases.   
Each of the next $q$ lines contains two space-separated integers, $a$ and $b$, the starting and ending integers in the ranges.     


**Constraints**

$1 \le q \le 100$  
$1 \le a \le b \le 10^9$  


**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:53:23.306Z  

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
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {
    int start = (int) Math.ceil(Math.sqrt(a));
    int end = (int) Math.floor(Math.sqrt(b));
    
    int count = end - start + 1;
    return Math.max(0, count);
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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

[View on HackerRank](https://www.hackerrank.com/challenges/sherlock-and-squares/problem)