problem link-https://www.spoj.com/problems/SUMMUL/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        /*
        g(n)=f(n)+n
        We can write the recurrence relation as f(n+1)=3·f(n)-f(n-1)+n
        substituting g(n) gives g(n+1)=3·g(n)-g(n-1) which is the bisection of Fibonacci sequence.
        hence, ans(n)=fibonacc(2*n)-n
         */

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            long ans[]=new long[2];
            fibo(2*n,ans);
            long an=(ans[0]-n+M)%M;
            sb.append(an+"\n");
        }
        System.out.print(sb);
    }

    static long a,b,c,d,M=1000000007;
    static void fibo(int n,long ans[])
    {
        if(n==0)
        {
            ans[0]=0;
            ans[1]=1;
            return;
        }
        fibo((n/2),ans);
        a=ans[0];             // F(n)
        b=ans[1];             // F(n+1)
        c=(b*2-a+M)%M;
        c=(a*c)%M;              // F(2n)
        d=((a*a)%M+(b*b)%M)%M;  // F(2n+1)
        if(n%2==0)
        {
            ans[0]=c;
            ans[1]=d;
        }
        else
        {
            ans[0]=d;
            ans[1]=(c+d)%M;
        }
    }
}
