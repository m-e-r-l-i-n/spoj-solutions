problem link-https://www.spoj.com/problems/JEDNAKOS/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        String s[]=bu.nextLine().split("=");
        s[0]='#'+s[0];
        char a[]=s[0].toCharArray(); int b=Integer.parseInt(s[1]);

        int n=a.length-1,dp[][]=new int[b+1][n+1],i,j;
        for(i=0;i<=b;i++)
        for(j=0;j<=n;j++)
        dp[i][j]=Integer.MAX_VALUE-10000;

        dp[0][0]=-1;
        int x,u=1,k;
        while(true)
        {
            x=a[n-u+1]-'0';
            if(x!=0) break;
            dp[x][u]=0;
            u++;
        }

        for(i=u;i<=n;i++)
        for(j=i-1;j>=i-4 && j>=0;j--)
        {
            x=getsum(a,n-i,n-j);
            for(k=0;k+x<=b;k++)
            {
                dp[k+x][i]=Math.min(dp[k+x][i],dp[k][j]+1);
                if(x==0) dp[k][i]=Math.min(dp[k][i],dp[k][j]);
            }

        }
        System.out.print(dp[b][n]);
    }

    static int getsum(char a[],int l,int r)
    {
        int ans=0,i;
        for(i=l+1;i<=r;i++)
        ans=10*ans+(a[i]-'0');
        return ans;
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st==null || !st.hasMoreElements())
            {
                try
                {st=new StringTokenizer(br.readLine());}
                catch(IOException e)
                {e.printStackTrace();}
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        String nextLine()
        {
            String str="";
            try
            {str=br.readLine();}
            catch(IOException e)
            {e.printStackTrace();}
            return str;
        }
    }
}
