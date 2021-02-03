problem link-https://www.spoj.com/problems/FASTFLOW/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bu.readLine().trim());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        int i,j;
        g=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(i=0;i<m;i++)
        {
            st=new StringTokenizer(bu.readLine());
            int u=Integer.parseInt(st.nextToken())-1,v=Integer.parseInt(st.nextToken())-1,c=Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v,g[v].size(),0,c));
            g[v].add(new Edge(u,g[u].size()-1,0,c));
        }

        long ans=0; d=new int[n]; w=new int[n];
        while(bfs())
        {
            Arrays.fill(w,0);
            int res=dfs(0,Integer.MAX_VALUE);
            while(res!=0)
            {
                ans+=res;
                res=dfs(0,Integer.MAX_VALUE);
            }
        }
        System.out.print(ans);
    }
    static ArrayList<Edge> g[];
    static int d[],w[];

    static boolean bfs()
    {
        Arrays.fill(d,-1);
        d[0]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(Edge e:g[p])
            {
                int v=e.to;
                if(d[v]<0 && e.f<e.c)
                {
                    d[v]=d[p]+1;
                    q.add(v);
                }
            }
        }
        return d[d.length-1]>=0;
    }

    static int dfs(int u,int f)
    {
        if(u==d.length-1) return f;
        int i=w[u];
        while(i<g[u].size())
        {
            Edge e=g[u].get(i);
            i++; w[u]++;
            if(e.c<=e.f) continue;
            int v=e.to;
            if(d[v]==d[u]+1)
            {
                int df=dfs(v,Math.min(f,e.c-e.f));
                if(df>0)
                {
                    e.f+=df;
                    g[v].get(e.rev).f-=df;
                    return df;
                }
            }
        }
        return 0;
    }

    static class Edge
    {
        int to,rev,f,c;
        Edge(int a,int b,int c,int d)
        {
            to=a;
            rev=b;
            f=c;
            this.c=d;
        }
    }
}
