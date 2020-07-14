problem link-https://www.spoj.com/problems/SMPSEQ4/

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
		int n=Integer.parseInt(bu.readLine()),i;
		String s[]=bu.readLine().split(" ");
		ArrayList<Integer> a=new ArrayList<>();
		for(i=0;i<n;i++)
		a.add(Integer.parseInt(s[i]));
		int m=Integer.parseInt(bu.readLine()),j;
		s=bu.readLine().split(" ");
		ArrayList<Integer> b=new ArrayList<>();
		for(i=0;i<m;i++)
		b.add(Integer.parseInt(s[i]));
		
		StringBuilder sb=new StringBuilder();
		for(i=0;i<n;i++)
		if(b.contains(a.get(i))) sb.append(a.get(i)+" ");
		System.out.print(sb);
	}
}
