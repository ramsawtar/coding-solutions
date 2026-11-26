# Library Fine

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:	

1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: $fine = 0)$.
2. If the book is returned after the expected return *day* but still within the same calendar month and year as the expected return date, $fine = 15 \text{ Hackos } \times \text{ (the number of days late)}$.	
3. If the book is returned after the expected return *month* but still within the same calendar year as the expected return date, the $fine = 500 \text{ Hackos } \times \text{ (the number of months late)}$.   
4. If the book is returned after the calendar *year* in which it was expected, there is a fixed fine of $10000 \text{ Hackos}$.

Charges are based only on the least precise measure of lateness.  For example, whether a book is due January 1, 2017 or December 31, 2017, if it is returned January 1, 2018, that is a year late and the fine would be $10,000 \text{ Hackos}$.  

**Example**  
$d1, m1, y1 = 14, 7, 2018$  
$d2, m2, y2 = 5, 7, 2018$  

The first values are the return date and the second are the due date.  The years are the same and the months are the same.  The book is $14 - 5 = 9$ days late.  Return $9 * 15 = 135$.  

**Function Description**  

Complete the *libraryFine* function in the editor below.  

libraryFine has the following parameter(s):  

- *d1, m1, y1*: returned date day, month and year, each an integer  
- *d2, m2, y2*: due date day, month and year, each an integer    

**Returns**  

- *int:*  the amount of the fine or $0$ if there is none

**Input Format**

The first line contains $3$ space-separated integers, $d1, m1, y1$, denoting the respective $day$, $month$, and $year$ on which the book was returned.		
The second line contains $3$ space-separated integers, $d2, m2, y2$, denoting the respective $day$, $month$, and $year$ on which the book was due to be returned.

**Constraints**

- $1 \le d1, d2 \le 31$		
- $1 \le m1, m2 \le 12$		
- $1 \le y1, y2 \le 3000$  
- $\text{It is guaranteed that the dates will be valid Gregorian calendar dates.}$  

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T09:44:36.099Z  

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
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    if (y1 > y2) {
        return 10000;
    }
    if (y1 == y2) {
        if (m1 > m2) {
            return 500 * (m1 - m2);
        }
        if (m1 == m2 && d1 > d2) {
            return 15 * (d1 - d2);
        }
    }
    return 0;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/library-fine/problem)