problem link-https://www.spoj.com/problems/EDIST/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            char a[]=bu.readLine().toCharArray(),b[]=bu.readLine().toCharArray();
            int i,j,n=a.length,m=b.length,dp[][]=new int[n+1][m+1];
            for(i=0;i<=n;i++)
            for(j=0;j<=m;j++)
            if(i==0) dp[i][j]=j;
            else if(j==0) dp[i][j]=i;
            else if(a[i-1]==b[j-1]) dp[i][j]=dp[i-1][j-1];
            else dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            sb.append(dp[n][m]+"\n");
        }
        System.out.print(sb);
    }

}
