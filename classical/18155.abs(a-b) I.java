problem link-https://www.spoj.com/problems/ABSP1/

/* package whatever; // don't place package name! */

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Spoj
{
	public static void main (String[] args) throws Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			int n=Integer.parseInt(bu.readLine());
			int i,k=0;
			String s[]=bu.readLine().split(" ");
			long sum=0;
			for(i=0;i<n;i++)
			{
				k=Integer.parseInt(s[i]);
				sum+=i*k-(n-i-1)*k;
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb);
	}
}
