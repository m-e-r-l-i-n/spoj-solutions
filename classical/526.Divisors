problem link-https://www.spoj.com/problems/DIV/

import java.io.*;
import java.util.*;

class Div
{
    public static void main(String args[])throws Exception
    {
        int i,j,t,n=1000000,d[]=new int[n+1];
        ArrayList<Integer> a[]=new ArrayList[n+1];
        for(i=1;i<=n;i++)
        for(j=i;j<=n;j+=i)
        {
            d[j]++;
            if(i==1)
            {
                ArrayList<Integer> te=new ArrayList<>();
                a[j]=te;
            }
        }
        for(i=2;i<=n;i++)
        if(a[i].size()==0)
        {
            for(j=i;j<=n;j+=i) a[j].add(i);
        }

        StringBuilder sb=new StringBuilder();
        t=0;
        for(i=1;i<=n;i++)
        {
            j=d[i];
            if(a[j].size()==2 && (int)(a[j].get(0)*a[j].get(1))==j)
            {
                t++;
                if(t%9==0) sb.append(i+"\n");
            }
        }
        System.out.print(sb);
    }
}
