problem link-https://www.spoj.com/problems/NAJPWG/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,j,N=100000,t=Integer.parseInt(bu.readLine());
        long c[]=new long[N+1];
        for(i=0;i<=N;i++) c[i]=i;
        for(i=2;i<=N;i++)   //get etf values for all 1-N
        if(c[i]==i)
        {
            c[i]--;
            for(j=2*i;j<=N;j+=i)
            c[j]=(c[j]/i)*(i-1);
        }

        for(i=1;i<=N;i++)    //n-etf values=numbers which give gcd>1
        {
            c[i]=i-c[i];
            c[i]+=c[i-1];   //calculate cumulative sums
        }

        for(i=1;i<=t;i++)
        {
            int n=Integer.parseInt(bu.readLine());
            sb.append("Case "+i+": "+c[n]+"\n");
        }
        System.out.print(sb);
    }
}
