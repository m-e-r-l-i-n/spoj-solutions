problem link-https://www.spoj.com/problems/SQFREE/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        sieve(); precal();
        while(t-->0)
        {
            long n=Long.parseLong(bu.readLine());
            long ans=n;
            for(int i=0;i<p.size();i++)
            {
                long x=p.get(i),zz=x*x;
                if(zz>n) break;
                ans+=(n/zz)*mob.get(i);
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int N=10000007,a[]=new int[N];
    static ArrayList<Integer> p,mob;
    static BitSet b=new BitSet();

    static void sieve()
    {
        int i,x=N/2,y=(int)(Math.sqrt(N)/2);
        long j;
        for(i=1;i<y;i++)
        for(j=1l*i*(i+1)*2; j<x; j+=(2*i+1)) b.set((int)j);

        p=new ArrayList<>();
        p.add(2);
        a[0]=a[1]=a[2]=1;
        for(i=3;i<N;i+=2)
        {
            a[i]=a[i-1]=1;
            if(!b.get(i/2)) p.add(i);   //generating primes
        }
        a[N-1]=a[N-2]=a[N-3]=1; //Arrays.fill(a,1), sorry sir, too time consuming
    }

    static void precal()
    {
        int i,x,j;
        for(i=0; 1l*p.get(i)*p.get(i)<N;i++)
        {
            x=p.get(i)*p.get(i);
            for(j=x;j<N;j+=x)
            a[j]=0;
        }

        for(i=0;i<p.size();i++)
        {
            x=p.get(i);
            for(j=x;j<N;j+=x) a[j]*=-1;
        }

        p=new ArrayList<>(); mob=new ArrayList<>(); //reuse p, we dont need primes anymore, we did what we had to
        for(i=2;i<N;i++)
        {
            if(a[i]==0) continue;
            p.add(i);
            mob.add(a[i]);  //mobius function values
        }
    }
}
