problem link-https://www.spoj.com/problems/SUPPER/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=10;
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int a[]=new int[n],i,d[]=new int[n+1],lis[]=new int[n+1],lds[]=new int[n+1],j,c=0;
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                d[i]=110000;
                a[i]=Integer.parseInt(s[i]);
            }
            d[0]=-110000;
            d[n]=110000;

            for(i=0;i<n;i++)
            {
                j=upper(d,a[i]);
                lis[i]=j;
                if(d[j]==110000) c++;
                d[j]=a[i];
            }

            for(i=0;i<=n;i++) d[i]=110000;
            d[0]=-110000;

            for(i=n-1;i>=0;i--)
            {
                j=upper(d,-a[i]);
                lds[i]=j;
                d[j]=-a[i];
            }

            boolean v[]=new boolean[n+1]; int ans=0;
            for(i=0;i<n;i++)
            if(lds[i]+lis[i]-1==c) {v[a[i]]=true; ans++;}

            sb.append(ans+"\n");
            for(i=0;i<=n;i++)
            if(v[i]) sb.append(i+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int upper(int a[],int k)
    {
        int l=0,r=a.length-1,ans=0,m;
        while(l<=r)
        {
            m=(l+r)/2;
            if(a[m]>k)
            {
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
}
