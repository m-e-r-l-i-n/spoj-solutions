problem link-https://www.spoj.com/problems/CEQU/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Spoj
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine()),i;
		StringBuilder sb=new StringBuilder();
		for(i=1;i<=t;i++)
		{
			String s[]=bu.readLine().split(" ");
			int a=Integer.parseInt(s[0]), b=Integer.parseInt(s[1]), c=Integer.parseInt(s[2]);
			if(c==0) {sb.append("Case "+i+": Yes\n"); continue;}
			if(b>a) a=a^b^(b=a);
			int temp=0;
			while(true)
			{
				temp=b;
				b=a%b;
				a=temp;
				if(b==0) break;
			}
			
			if(c%a==0) sb.append("Case "+i+": Yes\n");
			else sb.append("Case "+i+": No\n");
		}
		System.out.print(sb);
	}
}
