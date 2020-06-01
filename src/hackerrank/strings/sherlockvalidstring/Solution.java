package hackerrank.strings.sherlockvalidstring;

/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

Function Description

Complete the isValid function in the editor below. It should return either the string YES or the string NO.

isValid has the following parameter(s):

s: a string
Input Format

A single string .

Constraints

Each character 
Output Format

Print YES if string  is valid, otherwise, print NO.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
Explanation 1

Frequency counts for the letters are as follows:

{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

There are two ways to make the valid string:

Remove  characters with a frequency of : .
Remove  characters of frequency : .
Neither of these is an option.

Sample Input 2

abcdefghhgfedecba
Sample Output 2

YES
Explanation 2

All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */

import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        for (char i : s.toCharArray()) {
            if (!h.containsKey(i)) {
                h.put(i, 0);
            }
            h.put(i, h.get(i) + 1);
        }

        boolean isValid = true;
        int n = h.get(s.charAt(0));
        for (int i : h.values()) {
            if (i != n) {
                isValid = false;
            }
        }

        if(isValid){
            System.out.println("YES");
            return;
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            isValid = true;
            h.put(s.charAt(i), h.get(s.charAt(i)) - 1);
            n = h.get(s.charAt(0));
            for (int t : h.values()) {
                if (t != n && t > 0) {
                    isValid = false;
                }
            }
            h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
            
            if(isValid){
               System.out.println("YES");
                return; 
            }
        }
        
        System.out.println("NO");
    }
}