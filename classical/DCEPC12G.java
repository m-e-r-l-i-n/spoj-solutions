problem link-https://www.spoj.com/problems/DCEPC12G/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,j,n=10000025,c[]=new int[n+1],p[]=new int[n+1];
        long fac[]=new long[n+1],M=1000000007;
        for(i=2;i<=n;i++)
            if(p[i]==0)
                for(j=i+i;j<=n;j+=i) p[j]=1;

        int cn=0;
        fac[0]=1; fac[1]=1;
        for(i=2;i<=n;i++)
        {
            if(p[i]==0) cn++;
            c[i]=cn;
            fac[i]=(fac[i-1]*i)%M;
        }

        HashMap<Integer,Integer> tot=new HashMap<>();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int x=Integer.parseInt(bu.readLine());
            if(tot.get(x)==null) tot.put(x,totient(x));
            int pr=c[x],to=tot.get(x),f=pr-to;
            if(f<0) f=0;
            long pow=fac[f];
            sb.append(power(to,pow)+"\n");
        }
        System.out.print(sb);
    }

    static int totient(int n)
    {
        int i;
        double ans=n;
        for(i=2;i*i<=n;i++)
            if(n%i==0)
            {
                while(n%i==0) n/=i;
                ans*=1.0-1.0/i;
            }
        if(n>1)
            ans*=1.0-1.0/n;
        return (int)ans;
    }

    static long power(long a,long b)
    {
        long M=1000000007,ans=1;
        while(b!=0)
        {
            if(b%2!=0) ans=(ans*a)%M;
            a=(a*a)%M;
            b/=2;
        }
        return ans%M;
    }
}
