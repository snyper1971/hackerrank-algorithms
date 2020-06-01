package hackerrank.strings.alternatingcharachters;

/*
You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string , remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string .

Constraints

Each string  will consist only of characters  and 
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.

image
 */

import java.util.Scanner;
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while(t-- > 0)
		{
			int count = 0;
			String str = s.nextLine();
			for(int i=1;i<str.length();i++)
			{
				if(str.charAt(i)==str.charAt(i-1))
				{
					count++;
				}
			}
			System.out.println(count);	
		}
	}

}