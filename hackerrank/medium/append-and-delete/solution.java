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
