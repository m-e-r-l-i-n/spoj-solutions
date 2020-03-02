problem link-https://www.spoj.com/problems/SMPSUM/

import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		String s[]=bu.readLine().split(" ");
		int a=Integer.parseInt(s[0]), b=Integer.parseInt(s[1]),i;
		int sum=0;
		for(i=a;i<=b;i++)
		sum+=i*i;
		System.out.print(sum);
	}
}
