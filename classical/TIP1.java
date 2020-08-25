problem link-https://www.spoj.com/problems/TIP1/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),N=10000000,i,j;
        int p[]=new int[N+1];
        for(i=1;i<=N;i++)
        p[i]=i;
        for(i=2;i<=N;i++)
        if(p[i]==i)
        {
            p[i]=i-1;
            for(j=2*i;j<=N;j+=i)
            p[j]=(p[j]/i)*(i-1);
        }

        int ans[]=new int[N+1],sm=-1; double min=Integer.MAX_VALUE;
        for(i=2;i<=N;i++)
        {
            ans[i]=sm;
            int no=p[i],c[]=new int[10];
            while(no!=0)
            {
                c[no%10]++;
                no/=10;
            }
            no=i;
            while(no!=0)
            {
                c[no%10]--;
                no/=10;
            }
            boolean perm=true;
            for(j=0;j<10;j++)
            if(c[j]!=0) {perm=false; break;}
            if(perm)
            {
                double tem=1.0*i/p[i];
                if(tem<=min)
                {
                    min=tem;
                    sm=i;
                }
            }
        }

        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            if(ans[n]==-1) sb.append("No solution.\n");
            else sb.append(ans[n]+"\n");
        }
        System.out.print(sb);
    }
}
