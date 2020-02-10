problem link-https://www.spoj.com/problems/PRIME1/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
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
		  int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
		  for(int i=l;i<=r;i++)
		  {
		    int f=0;
		    for(int j=2;j<=Math.sqrt(i);j++)
		    if(i%j==0) {f=1; break;}
		    if(f==0 && i!=1) sb.append(i+"\n");
		  }
		  sb.append("\n");
		}
		System.out.print(sb);
	}
}
