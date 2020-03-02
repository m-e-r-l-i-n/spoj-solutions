problem link-https://www.spoj.com/problems/ADDREV/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			String s[]=bu.readLine().split(" ");
			int a=Integer.parseInt(s[0]), b=Integer.parseInt(s[1]);
			int newa=0,newb=0;
			while(a>0)
			{
				newa=(10*newa)+a%10;
				a/=10;
			}
			while(b>0)
			{
				newb=(10*newb)+b%10;
				b/=10;
			}
			int sum=newa+newb,sumrev=0;
			while(sum>0)
			{
				sumrev=(10*sumrev)+sum%10;
				sum/=10;
			}
			sb.append(sumrev+"\n");
		}
		System.out.print(sb);
	}
}
