problem link-https://www.spoj.com/problems/RPLN/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),v;
        for(v=1;v<=t;v++)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),q=Integer.parseInt(s[1]);
            int i,a;
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a=Integer.parseInt(s[i]);
                update(0,n-1,i,a,0);
            }
            sb.append("Scenario #"+v+":\n");

            while(q-->0)
            {
                s=bu.readLine().split(" ");
                int x=Integer.parseInt(s[0])-1,y=Integer.parseInt(s[1])-1;
                sb.append(query(0,n-1,x,y,0)+"\n");
            }
        }
        System.out.print(sb);
    }
    static int N=100000,st[]=new int[4*N],a[]=new int[N];

    static void update(int ss,int se,int i,int v,int n)
    {
        if(i<ss || i>se) return;
        if(ss==se) st[n]=v;
        else
        {
            int m=ss+(se-ss)/2;
            if(i>=ss && i<=m) update(ss,m,i,v,2*n+1);
            else update(m+1,se,i,v,2*n+2);
            st[n]=Math.min(st[2*n+1],st[2*n+2]);
        }
    }

    static int query(int ss,int se,int qs,int qe,int n)
    {
        if(qs<=ss && qe>=se) return st[n];
        if(se<qs || ss>qe) return Integer.MAX_VALUE;

        int m=ss+(se-ss)/2;
        return Math.min(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
    }
}
