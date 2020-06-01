package hackerrank.strings.commonchild;

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings,  and .

Constraints

All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string , such that  is a child of both  and .

Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from  and  is , whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

 and  have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3
 is the longest child of the given strings.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        char x[]=br.readLine().toCharArray();
        
        char y[]=br.readLine().toCharArray();
        int a[][]=new int[x.length+1][];
        int dir[][]=new int[x.length+1][];//0 for terminating condtion,1=diagonal,2=left,3=upper
        for(int i=0;i<a.length;i++)
        {
            a[i]=new int[y.length+1];
            dir[i]=new int[y.length+1];
            //System.out.println(a[i].length);
        }
        for(int i=1;i<x.length+1;i++)
        {
            for(int j=1;j<a[0].length;j++)
            {
             /*   if(i==0||j==0)
                {
                    a[i][j]=0;
                    dir[i][j]=0;
                    continue;
                }*/
                if(x[i-1]==y[j-1])
                {
                    a[i][j]=a[i-1][j-1]+1;
                    dir[i][j]=1;//diagonal
                }
                else
                {
                    if(a[i-1][j]>a[i][j-1])//upper is greater
                    {
                        a[i][j]=a[i-1][j];
                        dir[i][j]=3;
                        
                    }
                    else//left is greater
                    {
                        a[i][j]=a[i][j-1];
                        dir[i][j]=2;    
                    }
                }
            }
        }
            
        int row=a.length-1;
        int col=a[0].length-1;
        System.out.println(a[row][col]);
    }
}
