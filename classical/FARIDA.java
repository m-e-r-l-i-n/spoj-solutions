problem link-https://www.spoj.com/problems/FARIDA/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),v=1;
        while(t-->0)
        {
            sb.append("Case "+ v++ +": ");
            int n=Integer.parseInt(bu.readLine());
            if(n==0)
            {
                bu.readLine();
                sb.append("0\n");
                continue;
            }
            String s[]=bu.readLine().split(" ");
            long dp[]=new long[n+1]; int i,a[]=new int[n];
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);
            if(n<2)
            {
                sb.append(a[0]+"\n");
                continue;
            }

            dp[1]=a[0];
            for(i=2;i<=n;i++)
            dp[i]=Math.max(dp[i-1],dp[i-2]+a[i-1]);
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);
    }
}
