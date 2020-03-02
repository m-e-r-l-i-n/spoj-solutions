problem link-https://www.spoj.com/problems/FCTRL/

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
			int n=Integer.parseInt(bu.readLine()),z=0,v=5,i;
			ArrayList<Integer> five=new ArrayList<>();
			five.add(5);
			for(i=2;v<n;i++)
			{v=v*5;
			five.add(v);}
			for(i=0;i<five.size();i++)
			z+=n/five.get(i);
			sb.append(z+"\n");
		}
		System.out.print(sb);
	}
}
