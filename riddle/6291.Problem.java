/* package whatever; // don't place package name! */

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
		int n=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(n-->0)
		{
			String s=bu.readLine();
			int co=0;
			for(int i=0;i<s.length();i++)
			{
				int c=s.charAt(i)-48;
				if(c==0||c==6||c==9) co++;
				if(c==8) co+=2;
			}
			sb.append(co+"\n");
		}
		System.out.print(sb);
	}
}
