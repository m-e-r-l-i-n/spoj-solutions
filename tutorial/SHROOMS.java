problem link-https://www.spoj.com/problems/SHROOMS/

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j;
            int g[][]=new int[n][m],l=0,r=1000000000,ans=0,mid;
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                for(j=0;j<m;j++)
                g[i][j]=Integer.parseInt(s[j]);
            }

            while(l<=r)
            {
                mid=(l+r)/2;
                if(possible(g,mid)) {ans=mid; r=mid-1;}
                else l=mid+1;
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static boolean possible(int a[][],int k)
    {
        int i,j,n=a.length,m=a[0].length;
        long g[][]=new long[n][m];
        g[0][0]=k;

        for(i=1;i<m;i++)
        {
            g[0][i]=g[0][i-1]+a[0][i];
            if(g[0][i]<0) g[0][i]=Math.min(Integer.MIN_VALUE,g[0][i]);  //this is used so that it can be made sure we never undertake this path
        }
        for(i=1;i<n;i++)
        {
            g[i][0]=g[i-1][0]+a[i][0];
            if(g[i][0]<0) g[i][0]=Math.min(Integer.MIN_VALUE,g[i][0]);
        }

        for(i=1;i<n;i++)
        for(j=1;j<m;j++)
        {
            g[i][j]=Math.max(g[i-1][j],g[i][j-1])+a[i][j];
            if(g[i][j]<0) g[i][j]=Math.min(Integer.MIN_VALUE,g[i][j]);
        }
        return g[n-1][m-1]>=0;
    }
}
