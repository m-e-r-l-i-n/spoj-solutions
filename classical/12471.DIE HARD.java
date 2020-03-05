problem link-https://www.spoj.com/problems/DIEHARD/

import java.io.*;
import java.util.*;

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
			int h=Integer.parseInt(s[0])+3,a=Integer.parseInt(s[1])+2,c=1;	//start in air
			while(true)
			{
				if(h>20 && a<=10)	//fire and air
				{
					h-=20-3;
					a+=5+2;
					c+=2;
				}
				else if(h>5 && a>10)	//water and air
				{
					h-=5-3;
					a-=10-2;
					c+=2;
				}
				else break;
			}
			sb.append(c+"\n");
		}
		System.out.print(sb);
	}
}
