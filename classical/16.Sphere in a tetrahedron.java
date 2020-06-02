problem link-https://www.spoj.com/problems/TETRA/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int t=Integer.parseInt(bu.readLine());
		while(t-->0)
		{
		    String s[]=bu.readLine().split(" ");
		    int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),c=Integer.parseInt(s[2]),
		    d=Integer.parseInt(s[3]),e=Integer.parseInt(s[4]),f=Integer.parseInt(s[5]);
		    
		    /*
		    so a bit of maths, how to calculate radius of sphere inside tetrahedron?
		    r=(3*volume of tetrahedron)/total surface area of tetrahedron
		    vol=√( 4.a.a.b.b.c.c - a.a(b.b+c.c-f.f)^2 - b.b(a.a+c.c-e.e)^2 - c.c(a.a+b.b-d.d)^2 + (b.b+c.c-f.f).(a.a+c.c-e.e).(a.a+b.b-d.d) )/12
		    sa for each side=√(s.(s-a).(s-b).(s-c)) where s=(a+b+c)/2;
		    total tsa=sa for each of 4x
		    where 4x are the triangles with sides abd,ace,bcf,def
		    */
		    
		    double sa=tsa(a,b,d)+tsa(a,c,e)+tsa(b,c,f)+tsa(d,e,f);
		    double x=b*b+c*c-f*f,y=a*a+c*c-e*e,z=a*a+b*b-d*d,p=a*a,q=b*b,r=c*c,vol=Math.sqrt(p*q*r*4-x*x*p-y*y*q-z*z*r +x*y*z)/4.0;
		    sb.append(String.format("%.4f",vol/sa)+"\n");
		}
		System.out.print(sb);
	}
	
	static double tsa(int a,int b,int c)
	{
	    double s=(a+b+c)/2.0;
	    double ar=Math.sqrt(s*(s-a)*(s-b)*(s-c));
	    return ar;
	}
}
