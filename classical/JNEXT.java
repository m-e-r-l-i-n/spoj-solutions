problem link-https://www.spoj.com/problems/JNEXT/

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
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int i,j,a[]=new int[n],c[]=new int[10];
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);

            i=n-1;
            while(i>0)
            {
                if(a[i]>a[i-1]) break;  //find largest index where a[i]>a[i-1]
                i--;
            }
            if(i==0) {sb.append("-1\n"); continue;}  //no such index exists

            //swap the found element with the smallest number larger than it
            int min=9,minp=i;
            for(j=i;j<n;j++)
            if(a[j]<min && a[j]>a[i-1])
            {
                min=a[j];
                minp=j;
            }
            a[minp]=a[minp]^a[i-1]^(a[i-1]=a[minp]);
            j=i;
            for(i=0;i<n;i++)
            if(i<j) sb.append(a[i]);
            else c[a[i]]++;

            //build the smallest number possible after making the swap
            for(i=0;i<10;i++)
            for(j=0;j<c[i];j++)
            sb.append(i);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
