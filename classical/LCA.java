problem link-https://www.spoj.com/problems/LCA/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=bu.nextInt(),c=0;
        int d[]=new int[1500];
        while(t-->0)
        {
            int n=bu.nextInt(),i,j;
            g=new ArrayList[n+1];
            for(i=1;i<=n;i++)
            g[i]=new ArrayList<>();

            for(i=1;i<=n;i++)
            {
                int k,m=bu.nextInt();
                for(j=0;j<m;j++)
                {
                    k=bu.nextInt();
                    g[k].add(i);
                    g[i].add(k);
                }
            }
            eulertour(n);
            sb.append("Case "+ ++c+":\n");
            int q=bu.nextInt();
            while(q-->0)
            {
                int l=bu.nextInt()-1,r=bu.nextInt()-1;
                sb.append(lca(l,r)+"\n");
            }
        }
        System.out.print(sb);
    }

    static ArrayList<Integer> g[];
    static int level[],first[],st[],euler[];
    static void eulertour(int n)
    {
        ArrayList<Integer> tour=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        Stack<Integer> levl=new Stack<>();
        boolean vis[]=new boolean[n+1];
        s.add(1);
        levl.add(1);
        while(!s.isEmpty())
        {
            int p=s.pop(),lev=levl.pop();
            if(!vis[p])
            {
                vis[p]=true;
                for(int x:g[p])
                    if(!vis[x])
                    {
                        s.add(p); levl.add(lev);
                        s.add(x); levl.add(lev+1);
                    }
            }
            tour.add(p); l.add(lev);
        }
        first=new int[n];
        level=new int[l.size()]; euler=new int[l.size()];
        for(int i=0;i<tour.size();i++)
        {
            if(first[tour.get(i)-1]==0) first[tour.get(i)-1]=i+1;
            level[i]=l.get(i);
            euler[i]=tour.get(i);
        }
        int no=level.length,x=(int)(Math.log(no)/Math.log(2))+1;
        int size=2*(1<<x)-1;
        st=new int[size];
        build(0,0,no-1);
    }

    static void build(int i,int ss,int se)
    {
        if(ss==se) st[i]=ss;
        else
        {
            int mid=(ss+se)/2;
            build(i*2+1,ss,mid);
            build(i*2+2,mid+1,se);
            if(level[st[2*i+1]]<level[st[2*i+2]]) st[i]=st[2*i+1];
            else st[i]=st[2*i+2];
        }
    }

    static int rmq(int i,int l,int r,int x,int y)
    {
        if(x<=l && y>=r) return st[i];
        else if(r<x || l>y) return -1;

        int mid=(l+r)/2;
        int q1=rmq(2*i+1,l,mid,x,y),q2=rmq(2*i+2,mid+1,r,x,y);
        if(q1==-1) return q2;
        else if(q2==-1) return q1;

        return level[q1]<level[q2]?q1:q2;
    }

    static int lca(int u,int v)
    {
        if(first[u]>first[v]) u=u^v^(v=u);
        int x=first[u]-1,y=first[v]-1;
        int i=rmq(0,0,level.length-1,x,y);
        return euler[i];
    }

    static class FastReader
    {
        final private int BUFFER_SIZE=1<<16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer,bytesRead;

        public FastReader()
        {
            dis=new DataInputStream(System.in);
            buffer=new byte[BUFFER_SIZE];
            bufferPointer=bytesRead=0;
        }

        public int nextInt() throws IOException
        {
            int ret=0;
            byte c=read();
            while(c<=' ') c=read();
            boolean neg=(c=='-');
            if(neg) c=read();
            do
            {
                ret=ret*10+c-'0';
            }while((c=read())>='0' && c<='9');
            if(neg) return -ret;
            return ret;
        }

        private void fillBuffer()throws IOException
        {
            bytesRead=dis.read(buffer,bufferPointer=0,BUFFER_SIZE);
            if(bytesRead==-1) buffer[0]=-1;
        }
        private byte read() throws IOException
        {
            if(bufferPointer==bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
