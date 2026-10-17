# Sequence Equation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a sequence of $n$ integers, $p(1), p(2), \ldots, p(n)$ where each element is distinct and satisfies $1 \le p(x) \le n$. For *each* $x$ where $1 \le x \le n$, that is $x$ increments from $1$ to $n$, find any integer $y$ such that $p(p(y)) \equiv x$ and keep a history of the values of $y$ in a return array.

**Example**   

$p=[5,2,1,3,4]$    

Each value of $x$ between $1$ and $5$, the length of the sequence, is analyzed as follows:

1. $x=1\equiv p[3], p[4] = 3$, so $p[p[4]] = 1$
2. $x=2\equiv p[2], p[2] = 2$, so $p[p[2]] = 2$
3. $x=3\equiv p[4], p[5] = 4$, so $p[p[5]] = 3$
4. $x=4\equiv p[5], p[1] = 5$, so $p[p[1]] = 4$
5. $x=5\equiv p[1], p[3] = 1$, so $p[p[3]] = 5$


The values for $y$ are $[4, 2, 5, 1, 3]$.  

**Function Description**  

Complete the *permutationEquation* function in the editor below.   

permutationEquation has the following parameter(s):  

- *int p[n]:* an array of integers  

**Returns**   

- *int[n]:* the values of $y$ for all $x$ in the arithmetic sequence $1$ to $n$


**Input Format**

The first line contains an integer $n$, the number of elements in the sequence.  
The second line contains $n$ space-separated integers $p[i]$ where $1 \le i \le n$.

**Constraints**

+ $1 \le n \le 50$
+ $1 \le p[i] \le 50$, where $1 \le i \le n$.
+ Each element in the sequence is distinct.

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T06:48:57.631Z  

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
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
    int n = p.size();
        // Array to store the 1-based index of each number
        // Size is n + 1 because the numbers are from 1 to n
        int[] position = new int[n + 1];
        
        // Step 1: Map each value to its 1-based position
        for (int i = 0; i < n; i++) {
            position[p.get(i)] = i + 1;
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Step 2: For each x from 1 to n, find y such that p(p(y)) = x
        for (int x = 1; x <= n; x++) {
            int p_y = position[x];   // Find where x is located
            int y = position[p_y];   // Find where that position value is located
            result.add(y);
        }
        
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/permutation-equation/problem)