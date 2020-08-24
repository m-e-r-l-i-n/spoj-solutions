problem link-https://www.spoj.com/problems/KOPC12A/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int a[]=new int[n],c[]=new int[n],i;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            c[i]=Integer.parseInt(s[i]);
            int l=0,r=100000;
            long ans=Long.MAX_VALUE;
            for(i=0;i<=100;i++)
            if(l<r)
            {
                int mid1=l+(r-l)/3,mid2=r-(r-l)/3;
                long v1=calculate(a,c,mid1),v2=calculate(a,c,mid2);
                ans=Math.min(ans,Math.min(v1,v2));
                if(v1>=v2) l=mid1;
                else r=mid2;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long calculate(int a[],int c[],int k)
    {
        long sum=0; int i;
        for(i=0;i<a.length;i++)
        sum+=1l*Math.abs(k-a[i])*c[i];
        return sum;
    }
}
