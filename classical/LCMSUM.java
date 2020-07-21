problem link-https://www.spoj.com/problems/LCMSUM/

import java.io.*;
class Lcmsum
{
    public static void main(String args[])throws Exception
    {
        int i,j,t,n=1000000;
        long ans[]=new long[n+1],phi[]=new long[n+1];

        for(i=0;i<=n;i++)  phi[i]=i;
        for(i=2;i<=n;i++)
        if(phi[i]==i)
        {
            phi[i]=i-1;
            for(j=i*2;j<=n;j+=i) phi[j]=(phi[j]*(i-1))/i; //calculating etf values
        }
        for(i=1;i<=n;i++)
        for(j=i;j<=n;j+=i)
            ans[j]+=phi[i]*i;

        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int num=Integer.parseInt(bu.readLine());
            long a=ans[num]+1;
            a=(a*num)/2;
            sb.append(a+"\n");
        }
        System.out.print(sb);
    }
}
