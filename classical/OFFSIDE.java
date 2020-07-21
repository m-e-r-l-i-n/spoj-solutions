problem link-https://www.spoj.com/problems/OFFSIDE/

import java.io.*;
import java.util.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true)
		{
			String s[]=bu.readLine().split(" ");
			int at=Integer.parseInt(s[0]), de=Integer.parseInt(s[1]);
			if(at==0 && de==0) break;
			int a[]=new int[at], d[]=new int[de];
			
			s=bu.readLine().split(" ");
			int i,min=100000;
			for(i=0;i<at;i++)
			{a[i]=Integer.parseInt(s[i]);
			if(a[i]<min) min=a[i];}
			
			s=bu.readLine().split(" ");
			for(i=0;i<de;i++)
			d[i]=Integer.parseInt(s[i]);
			if(de==1) {sb.append("Y\n"); continue;}
			Arrays.sort(d);
			
			if(min<d[1])
			sb.append("Y\n");
			else sb.append("N\n");
		}
		System.out.print(sb);
	}
}
