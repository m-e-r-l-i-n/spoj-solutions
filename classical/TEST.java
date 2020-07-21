problem link-https://www.spoj.com/problems/TEST/

import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> l=new ArrayList<>();
		String s=bu.readLine();
		while(s!=null)
		{if(Integer.parseInt(s)==42)
		break;
		else
		l.add(Integer.parseInt(s));
		s=bu.readLine();}
		for(int i=0;i<l.size();i++)
		System.out.println(l.get(i));		
	}
}
