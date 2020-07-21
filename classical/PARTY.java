problem link-https://www.spoj.com/problems/PARTY/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[1]),w=Integer.parseInt(s[0]);
            if(n==0 && w==0) break;
            int i,j,a[][]=new int[n][2],k[][]=new int[n+1][w+1];
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                a[i][0]=Integer.parseInt(s[0]); //weights
                a[i][1]=Integer.parseInt(s[1]); //values
            }
            for(i=0;i<=n;i++)
            for(j=0;j<=w;j++)
            if(i==0 || j==0) k[i][j]=0;
            else if(a[i-1][0]<=j) k[i][j]=Math.max(a[i-1][1]+k[i-1][j-a[i-1][0]],k[i-1][j]);
            else k[i][j]=k[i-1][j];

            int max=k[n][w],min=0;
            for(i=0;i<=w;i++)
            if(k[n][i]==max) {min=i; break;}
            sb.append(min+" "+max+"\n");
            bu.readLine();
        }
        System.out.print(sb);
    }

}
