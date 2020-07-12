problem link-https://www.spoj.com/problems/LOCKER/

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
            long n=Long.parseLong(bu.readLine());
            long r=n/3; n=n%3;
            if(n==1 && r>0) {r--; n=4;}
            if(n==0) n=1;
            long ans=power(r)*n%1000000007;
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long power(long b)
    {
        long res=1,a=3,M=1000000007;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
