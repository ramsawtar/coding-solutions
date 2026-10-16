# Circular Array Rotation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

John Watson knows of an operation called a _right circular rotation_ on an array of integers.  One rotation operation moves the last array element to the first position and shifts all remaining elements right one.  To test Sherlock's abilities, Watson provides Sherlock with an array of integers.  Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.

For each array, perform a number of right circular rotations and return the values of the elements at the given indices.

**Example**  
$a=[3,4,5]$  
$k=2$  
$queries = [1,2]$  

Here $k$ is the number of rotations on $a$, and $queries$ holds the list of indices to report.  First we perform the two rotations: $[3,4,5] \rightarrow [5,3,4] \rightarrow [4,5,3]$  

Now return the values from the zero-based indices $1$ and $2$ as indicated in the $queries$ array.  
$a[1] = 5$  
$a[2] = 3$  

**Function Description**  

Complete the *circularArrayRotation* function in the editor below.  

circularArrayRotation has the following parameter(s):  

- *int a[n]*: the array to rotate  
- *int k*: the rotation count  
- *int queries[1]*: the indices to report  

**Returns**  

- *int[q]:* the values in the rotated $a$ as requested in $m$

**Input Format**

The first line contains $3$ space-separated integers, $n$, $k$, and $q$, the number of elements in the integer array, the rotation count and the number of queries.  
The second line contains $n$ space-separated integers, where each integer $i$ describes array element $a[i]$ (where $0 \le i \lt n$).	
Each of the $q$ subsequent lines contains a single integer, $queries[i]$, an index of an element in $a$ to return.

**Constraints**

- $1 \le n \le 10^5$
- $1 \le a[i] \le 10^5$
- $1 \le k \le 10^5$
- $1 \le q \le 500$    
- $0 \le queries[i] \lt n$

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-16T18:09:35.500Z  

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
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
    // Write your code here
    
    int n = a.size();
        // Reduce k to the effective number of rotations
        int effectiveK = k % n;
        
        List<Integer> result = new ArrayList<>();
        
        for (int q : queries) {
            // Find the index in the original array
            int originalIndex = (q - effectiveK + n) % n;
            result.add(a.get(originalIndex));
        }
        
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

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

[View on HackerRank](https://www.hackerrank.com/challenges/circular-array-rotation/problem)