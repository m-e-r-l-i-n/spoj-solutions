problem link-https://www.spoj.com/problems/UJ/

import java.io.*;
import java.math.*;
class CDs
{
	public static void main(String args[])throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		String s[]=bu.readLine().split(" ");
		int n=Integer.parseInt(s[0]), d=Integer.parseInt(s[1]);
		while(n!=0 || d!=0)
		{
			System.out.println(BigInteger.valueOf(n).pow(d));
			s=bu.readLine().split(" ");
			n=Integer.parseInt(s[0]);d=Integer.parseInt(s[1]);
		}
	}
}
