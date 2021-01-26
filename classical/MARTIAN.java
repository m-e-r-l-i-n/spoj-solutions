problem link-https://www.spoj.com/problems/MARTIAN/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bu.readLine().trim());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        while(n!=0 && m!=0)
        {
            int i,j;
            long dp[][]=new long[n][m],a[][]=new long[n][m],b[][]=new long[n][m];
            for(i=0;i<n;i++)
            {
                st=new StringTokenizer(bu.readLine().trim());
                for(j=0;j<m;j++)
                {
                    a[i][j]=Integer.parseInt(st.nextToken());
                    if(j>0) a[i][j]+=a[i][j-1];
                }
            }

            for(i=0;i<n;i++)
            {
                st=new StringTokenizer(bu.readLine().trim());
                for(j=0;j<m;j++)
                {
                    b[i][j]=Integer.parseInt(st.nextToken());
                    if(i>0) b[i][j]+=b[i-1][j];
                }
            }

            for(i=0;i<n;i++)
            for(j=0;j<m;j++)
            {
                long l1=a[i][j],l2=b[i][j];
                if(i>0) l1+=dp[i-1][j];
                if(j>0) l2+=dp[i][j-1];
                dp[i][j]=Math.max(l1,l2);
            }
            sb.append(dp[n-1][m-1]+"\n");

            st=new StringTokenizer(bu.readLine().trim());
            n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
