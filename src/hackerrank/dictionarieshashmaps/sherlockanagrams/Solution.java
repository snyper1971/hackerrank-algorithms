package hackerrank.dictionarieshashmaps.sherlockanagrams;

/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries.
Each of the next  lines contains a string  to analyze.

Constraints



String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and  respectively.

For the second query:
There are 6 anagrams of the form  at positions  and .
There are 3 anagrams of the form  at positions  and .
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and .
There are three anagrammatic pairs of length :  at positions  respectively.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int count[][] = new int[128][110];

    private static void resetCount() {
        for (int i = 0; i < count.length; i++) for (int j = 0; j < count[i].length; j++) count[i][j] = 0;
    }
    
    private static boolean areAnagrams(int from1, int to1, int from2, int to2) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i][to1+1]-count[i][from1] != count[i][to2+1]-count[i][from2])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int TC = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < TC; tc++) {
            final char s[] = sc.nextLine().toCharArray();
            resetCount();
            count[s[0]][1] = 1;
            for (int i = 1; i < s.length; i++) {
                for (int j = 'a'; j <= 'z'; j++) count[j][i+1] = count[j][i];
                count[s[i]][i+1]++;
            }
            int res = 0;
            for (int len = 1; len <= s.length-1; len++) {
                for (int from = 0; from <= s.length-len; from++) {
                    for (int to = from+1; to <= s.length-len; to++) {
                        if (areAnagrams(from, from+len-1, to, to+len-1)) res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
