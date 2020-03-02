problem link-https://www.spoj.com/problems/LASTDIG/

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
			int a=Integer.parseInt(s[0])%10,b=Integer.parseInt(s[1]);
			if(b==0) {sb.append("1\n"); continue;}
			b=b%4;
			if(b==0) b=4;
			a=(int)Math.pow(a,b)%10;
			sb.append(a+"\n");
		}
		System.out.print(sb);
	}
}
