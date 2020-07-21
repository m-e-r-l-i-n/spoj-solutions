problem link-https://www.spoj.com/problems/ANARC09A/

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
		int t=1;
		StringBuilder sb=new StringBuilder();
		while(true)
		{
			String s=bu.readLine();
			if(s.contains("-")) break;
			int st=0,e=0,sw=0,i;
			for(i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c=='{') st++;
				if(c=='}')
				{
					if(st>0) st--;
					else {sw++; st++;}
				}
			}
			sw+=st/2;
			sb.append(t++ +". "+sw+"\n");
		}
		System.out.print(sb);
	}
}
