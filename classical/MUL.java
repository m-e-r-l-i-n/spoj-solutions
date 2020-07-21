problem link-https://www.spoj.com/problems/MUL/

/* package whatever; // don't place package name! */

import java.util.*;
import java.math.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			String s[]=bu.readLine().split(" ");
			BigInteger a=new BigInteger(s[0]); 
			BigInteger b=new BigInteger(s[1]);
			sb.append(a.multiply(b)+"\n");
		}
		System.out.print(sb);
	}
}
