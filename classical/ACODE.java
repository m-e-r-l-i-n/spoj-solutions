problem link-https://www.spoj.com/problems/ACODE/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s=bu.readLine();
        while(s.equals("0")==false)
        {
            s=' '+s;
            int n=s.length(),i; long dp[]=new long[n];
            dp[0]=dp[1]=1;
            for(i=2;i<n;i++)
            {
                if(s.charAt(i)!='0') dp[i]=dp[i-1];
                int x=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
                if(x>=10 && x<=26) dp[i]+=dp[i-2];
            }
            sb.append(dp[n-1]+"\n");
            s=bu.readLine();
        }
        System.out.print(sb);
    }
}
