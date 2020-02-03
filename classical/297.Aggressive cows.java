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
			int n=Integer.parseInt(s[0]), c=Integer.parseInt(s[1]),i,a[]=new int[n];
			for(i=0;i<n;i++)
			a[i]=Integer.parseInt(bu.readLine());
			Arrays.sort(a);
			sb.append(binsearch(a,c)+"\n");
		}
		System.out.print(sb);
	}
	
	static int binsearch(int a[],int c)
	{
    int ini=0,last=a[a.length-1],max=-1;
    while(last>ini)
    {
        int mid=(ini+last)/2;
        if(func(mid,a,c)==1)
        {
            if(mid>max) max=mid;
            ini=mid+1;
        }
        else last=mid;
    }
    return max;
	}
	
	static int func(int n,int a[],int c)
	{
    int cows=1,pos=a[0],i;
    for (i=1;i<a.length;i++)
    {
        if(a[i]-pos>=n)
        {
            pos=a[i];
            cows++;
            if(cows==c)
                return 1;
        }
    }
    return 0;
	}
	
}
