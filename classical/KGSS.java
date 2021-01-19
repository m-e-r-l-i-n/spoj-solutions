problem link-https://www.spoj.com/problems/KGSS/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            update(0,n-1,i,0);
        }
        int q=Integer.parseInt(bu.readLine());
        while(q-->0)
        {
            s=bu.readLine().split(" ");
            int x=Integer.parseInt(s[1])-1,y=Integer.parseInt(s[2]);
            if(s[0].equals("U"))
            {
                a[x]=y;
                update(0,n-1,x,0);
            }
            else
            {
                y--;
                int m1=query(0,n-1,x,y,0),tem=a[m1];
                a[m1]=0; update(0,n-1,m1,0);

                int m2=query(0,n-1,x,y,0);
                sb.append(tem+a[m2]+"\n");
                a[m1]=tem;
                update(0,n-1,m1,0);
            }
        }
        System.out.print(sb);
    }
    static int N=100000,st[]=new int[4*N],a[]=new int[N];

    static void update(int ss,int se,int i,int n)
    {
        if(i<ss || i>se) return;
        if(ss==se) st[n]=i;
        else
        {
            int m=ss+(se-ss)/2;
            if(i>=ss && i<=m) update(ss,m,i,2*n+1);
            else update(m+1,se,i,2*n+2);
            if(a[st[2*n+1]]>a[st[2*n+2]]) st[n]=st[2*n+1];
            else st[n]=st[2*n+2];
        }
    }

    static int query(int ss,int se,int qs,int qe,int n)
    {
        if(qs<=ss && qe>=se) return st[n];
        if(se<qs || ss>qe) return -1;

        int m=ss+(se-ss)/2;
        int e1=query(ss,m,qs,qe,2*n+1),e2=query(m+1,se,qs,qe,2*n+2);
        if(e1==-1 && e2==-1) return -1;
        else if(e1!=-1 && e2==-1) return e1;
        else if(e1==-1 && e2!=-1) return e2;
        else
        {
            if(a[e1]>a[e2]) return e1;
            else return e2;
        }
    }
}
