problem link-https://www.spoj.com/problems/SMPCIRC/

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
			int x1=Integer.parseInt(s[0]),y1=Integer.parseInt(s[1]),r1=Integer.parseInt(s[2]),
			x2=Integer.parseInt(s[3]),y2=Integer.parseInt(s[4]),r2=Integer.parseInt(s[5]);
			if(r1==r2 && x1==x2 && y1==y2) {sb.append("O\n"); continue;}
			double c=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			double d=Math.abs(r1-r2);
			if(c==d) sb.append("E\n");
			else if(c<d) sb.append("I\n");
			else sb.append("O\n");
		}
		System.out.print(sb);
	}
}
