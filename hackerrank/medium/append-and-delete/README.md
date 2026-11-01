# Append and Delete

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You have two strings of lowercase English letters. You can perform two types of operations on the first string:

1. *Append* a lowercase English letter to the end of the string.
2. *Delete* the last character of the string. Performing this operation on an empty string results in an empty string.

Given an integer, $k$, and two strings, $s$ and $t$, determine whether or not you can convert $s$ to $t$ by performing *exactly* $k$ of the above operations on $s$. If it's possible, print `Yes`.  Otherwise, print `No`.

**Example**. 
$s=[a,b,c]$  
$t=[d,e,f]$  
$k=6$  

To convert $s$ to $t$, we first delete all of the characters in $3$ moves.  Next we add each of the characters of $t$ in order.  On the $6^{th}$ move, you will have the matching string.  Return `Yes`.  

If there were more moves available, they could have been eliminated by performing multiple deletions on an empty string.  If there were fewer than $6$ moves, we would not have succeeded in creating the new string.  

**Function Description**  

Complete the *appendAndDelete* function in the editor below.  It should return a string, either `Yes` or `No`.  

appendAndDelete has the following parameter(s):  

- *string s*: the initial string  
- *string t*: the desired string  
- *int k*: the exact number of operations that must be performed  

**Returns**  

- *string:* either `Yes` or `No`

**Input Format**

The first line contains a string $s$, the initial string. 		
The second line contains a string $t$, the desired final string.  
The third line contains an integer $k$, the number of operations.


**Constraints**

- $1 \le |s| \le 100$
- $1 \le |t| \le 100$
- $1 \le k \le 100$
- $s$ and $t$ consist of lowercase English letters, $\text{ascii[a-z]}$.


**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:25:12.571Z  

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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    int commonLength = 0;
    int minLength = Math.min(s.length(), t.length());
    
    // Find the length of the common prefix
    for (int i = 0; i < minLength; i++) {
        if (s.charAt(i) == t.charAt(i)) {
            commonLength++;
        } else {
            break;
        }
    }
    
    int deletions = s.length() - commonLength;
    int appends = t.length() - commonLength;
    int totalMinOps = deletions + appends;
    
    // Check if k is less than the minimum required operations
    if (k < totalMinOps) {
        return "No";
    }
    // If k can absorb the extra moves via back-and-forth operations (even difference)
    else if ((k - totalMinOps) % 2 == 0) {
        return "Yes";
    }
    // If k is greater than or equal to the combined length of both strings,
    // we can always clear everything and build t from scratch.
    else if (k >= s.length() + t.length()) {
        return "Yes";
    } else {
        return "No";
    }
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/append-and-delete/problem)