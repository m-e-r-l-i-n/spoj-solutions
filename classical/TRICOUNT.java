problem link-https://www.spoj.com/problems/TRICOUNT/

import java.util.*;
import java.io.*;
class Ideone
{
public static void main (String[] args) throws Exception
{
	BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(bu.readLine());
	StringBuilder sb=new StringBuilder();
	while(t-->0)
	{
		long n=Long.parseLong(bu.readLine());
		n=n*(n+2)*(2*n+1);
		if(n%2==1) n--;
		sb.append(n/8+"\n");
	}
	System.out.print(sb);
}}
