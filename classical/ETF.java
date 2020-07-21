problem link-https://www.spoj.com/problems/ETF/

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
		int t=Integer.parseInt(bu.readLine()),i,a[]=new int[1000000];
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			int n=Integer.parseInt(bu.readLine());
			if(a[n-1]==0)
			a[n-1]=totient(n);
			sb.append(a[n-1]+"\n");
		}
		System.out.print(sb);
	}
	
	public static int totient(int n)
	{
		float r=n;
		for(int i=2;i*i<=n;i++)	//we have to take all prime factors of n
			if(n%i==0)
			{while(n%i==0)
			n/=i;
			r*=(1.0-(1.0/(float)i));	
			/*euler's formula to calculate coprime numbers phi=n x π(1-1/i) where i are the prime factors of n
								                                            i|n		*/
			}
		if(n>1)
		r*=1.0-(1.0/(float)n);
		return (int)r;
	}
}
