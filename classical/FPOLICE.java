problem link-https://www.spoj.com/problems/FPOLICE/

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
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
            int i,j;
            for(i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                for(j=0;j<n;j++)
                time[i][j]=Integer.parseInt(s[j]);
            }
            for(i=0;i<n;i++)
            {
                s=bu.readLine().split(" ");
                for(j=0;j<n;j++)
                risk[i][j]=Integer.parseInt(s[j]);
            }
            int ans=solve(n-1,n,m),ans2=0;
            if(ans==M) {sb.append("-1\n"); continue;}

            for(i=0;i<=m;i++)
            if(solve(n-1,n,i)==ans)
            {
                ans2=i;
                break;
            }
            sb.append(ans+" "+ans2+"\n");
        }
        System.out.print(sb);
    }

    static int time[][]=new int[101][101],risk[][]=new int[101][101],dp[][]=new int[101][255],M=1000000000;

    static int solve(int s,int n,int t)
    {
        if(s==0 && t==0) return 0;
        if(t<0) return M;
        if(dp[s][t]!=-1) return dp[s][t];
        dp[s][t]=solve(s,n,t-1);
        for(int i=0;i<n;i++)
        if(t>=time[i][s]) dp[s][t]=Math.min(dp[s][t],solve(i,n,t-time[i][s])+risk[i][s]);
        return dp[s][t];
    }
}
