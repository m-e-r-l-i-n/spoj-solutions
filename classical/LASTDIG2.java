problem link-https://www.spoj.com/problems/LASTDIG2/

import java.io.*;
import java.util.*;
import java.math.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			String s[]=bu.readLine().split(" ");
			int a=s[0].charAt(s[0].length()-1)-48; long b=Long.parseLong(s[1]);
			if(b==0) {sb.append("1\n"); continue;}
			b=b%4;
			if(b==0) b=4;
			a=(int)Math.pow(a,(int)b)%10;
			sb.append(a+"\n");
		}
		System.out.print(sb);
	}
}
