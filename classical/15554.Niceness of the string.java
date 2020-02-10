problem link-https://www.spoj.com/problems/IITKWPCA/

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
			String s[]=bu.readLine().split("\\s+"),wd="";
			int i; 
			ArrayList<String> a=new ArrayList<>();
			for(i=0;i<s.length;i++)
			{
				if(s[i].equals("")) continue;
				if(a.contains(s[i])) continue;
				else a.add(s[i]);
			}
			sb.append(a.size()+"\n");
		}
		System.out.print(sb);
	}
} 
