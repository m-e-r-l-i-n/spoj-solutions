problem link-https://www.spoj.com/problems/ABCDEF/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ABC
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bu.readLine().trim());
		int a[]=new int[n],i,j,k;
		for(i=0;i<n;i++)
		a[i]=Integer.parseInt(bu.readLine().trim());
		
		HashMap<Integer,Integer> cnt=new HashMap<>();
		
		for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		for(k=0;k<n;k++)
		{
			int x=a[i]*a[j]+a[k];
			if(cnt.containsKey(x)) cnt.put(x,cnt.get(x)+1);
			else cnt.put(x,1);
		}
		
		int c=0;
		for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		for(k=0;k<n;k++)
		{
			int x=a[i]*(a[j]+a[k]);
			if(a[i]==0) continue;
			if(cnt.containsKey(x))
			c+=cnt.get(x);
		}
		System.out.print(c);
	}
}
