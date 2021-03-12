//problem link-https://www.spoj.com/problems/BRCKTS/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int v;
        for(v=1;v<=10;v++)
        {
            sb.append("Test "+v+":\n");
            int n=Integer.parseInt(bu.readLine());
            char c[]=bu.readLine().trim().toCharArray();
            st=new int[4*n]; l=new int[4*n];

            int i,s=0; boolean b[]=new boolean[n];
            for(i=0;i<n;i++)
            {
                if(c[i]=='(') {b[i]=true; s++;}
                else s--;
                update(0,n,i,i+1,s,1);
            }

            int q=Integer.parseInt(bu.readLine());
            while(q-->0)
            {
                int t=Integer.parseInt(bu.readLine());
                t--;
                if(t==-1)
                {
                    int a1=query(0,n,0,n,1),a2=query(0,n,n-1,n,1);
                    if(a1==0 && a2==0) sb.append("YES\n");
                    else sb.append("NO\n");
                }
                else
                {
                    int u=2;
                    if(b[t]) u=-2;
                    update(0,n,t,n,u,1);
                    b[t]=!b[t];
                }
            }
        }
        System.out.print(sb);
    }
    static int st[],l[];

    static void update(int ss,int se,int us,int ue,int v,int n)
    {
        st[n]+=l[n];
        if(ss+1!=se)
        {
            l[2*n]+=l[n];
            l[2*n+1]+=l[n];
        }
        l[n]=0;

        if(ss>=ue || se<=us) return;
        if(ss>=us && se<=ue)
        {
            l[n]+=v;
            st[n]+=l[n];
            if(ss+1!=se)
            {
                l[2*n]+=l[n];
                l[2*n+1]+=l[n];
            }
            l[n]=0;
            return;
        }

        int mid=(se+ss)/2;
        update(ss,mid,us,ue,v,2*n);
        update(mid,se,us,ue,v,2*n+1);
        st[n]=Math.min(st[2*n],st[2*n+1]);
    }

    static int query(int ss,int se,int qs,int qe,int n)
    {
        st[n]+=l[n];
        if(ss+1!=se)
        {
            l[2*n]+=l[n];
            l[2*n+1]+=l[n];
        }
        l[n]=0;

        if(ss>=qe || se<=qs) return Integer.MAX_VALUE;
        if(ss>=qs && se<=qe) return st[n];
        int mid=(se+ss)/2;
        return Math.min(query(ss,mid,qs,qe,2*n),query(mid,se,qs,qe,2*n+1));
    }
}
