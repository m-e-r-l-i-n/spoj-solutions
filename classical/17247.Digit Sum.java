problem link-https://www.spoj.com/problems/PR003004/

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
            long a=Long.parseLong(s[0]),b=Long.parseLong(s[1]);
            if(a!=0) a--;
            long ans=0;
            if(b!=0) ans=sum(b);
            if(a>0) ans-=sum(a);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static long dp[]=new long[30],fp[]=new long[30];

    static long sum(long n)
    {
        Arrays.fill(dp,-1);
        Arrays.fill(fp,-1);
        ArrayList<Integer> al=new ArrayList<>();
        while(n!=0)
        {
            al.add((int)(n%10));
            n/=10;
        }
        return calc(al,al.size()-1,1).y;
    }

    static Pair calc(ArrayList<Integer> al,int i,int f)
    {
        if(i==-1) return new Pair(1,0);
        if(f==0 && dp[i]!=-1) return new Pair(dp[i],fp[i]);
        int x,end=0;
        if(f!=0) end=al.get(i);
        else end=9;
        long res=0,fc=0;
        for(x=0;x<=end;x++)
        {
            int u=0;
            if(f!=0 && x==end) u=1;
            Pair p=calc(al,i-1,u);
            res+=p.x;
            fc+=1l*x*p.x+p.y;
        }
        if(f==0) {dp[i]=res; fp[i]=fc;}
        return new Pair(res,fc);
    }

    static class Pair
    {
        long x,y;
        Pair(long a,long b)
        {
            x=a; y=b;
        }
    }
}
