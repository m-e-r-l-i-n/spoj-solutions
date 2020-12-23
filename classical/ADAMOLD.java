problem link-https://www.spoj.com/problems/ADAMOLD/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1])+1;
        if(k>n) k=n;    //most important step tbh

        int i,j,x,cut[][]=new int[n+5][n+5],c[][]=new int[n+5][31]; long dp[][]=new long[n+5][n+5];
        s=bu.readLine().split(" ");
        for(i=1;i<=n;i++)
        {
            x=Integer.parseInt(s[i-1]);
            for(j=0;j<31;j++)
            {
                c[i][j]=c[i-1][j];
                if(((x>>j)&1)==1) c[i][j]++;
            }
        }

        for(i=1;i<=n;i++)
        {
            cut[i][1]=0;
            dp[i][1]=range(c,1,i);
        }

        for(i=2;i<=n;i++)
        for(j=Math.min(i,k);j>1;j--)
        {
            int l=Math.max(cut[i-1][j],j-1),r=cut[i][j+1];
            if(j+1>Math.min(i,k)) r=i-1;
            dp[i][j]=(long)1e18;
            for(int q=l;q<=r;q++)
            {
                long here=dp[q][j-1]+range(c,q+1,i);
                if(here<=dp[i][j])
                {
                    cut[i][j]=q;
                    dp[i][j]=here;
                }
            }
        }
        System.out.print(dp[n][k]);
    }

    static long range(int c[][],int l,int r)
    {
        long res=0; int i;
        for(i=0;i<31;i++)
        {
            int cnt1=c[r][i]-c[l-1][i];
            int cnt0=(r-l+1)-cnt1;
            res+=1l*cnt1*cnt0*(1<<i);
        }
        return res;
    }
}
