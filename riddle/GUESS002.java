problem link-https://www.spoj.com/problems/GUESS002/

import java.io.*;
import java.math.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		String s[]=bu.readLine().split(" ");
		double x=Double.parseDouble(s[0]), y=Double.parseDouble(s[1]);
		System.out.format("%.1f",Math.pow(x,y));
	}
}
