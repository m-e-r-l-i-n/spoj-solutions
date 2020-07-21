problem link-https://www.spoj.com/problems/AKBAR/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=bu.nextInt();
        while(t-->0)
        {
            int n=bu.nextInt(),r=bu.nextInt(),m=bu.nextInt(),i;
            for(i=0;i<=n;i++)
            {
                g[i]=new ArrayList<>();
                flag[i]=0;
                vis[i]=false;
            }

            for(i=0;i<r;i++)
            {
                int u=bu.nextInt(),v=bu.nextInt();
                g[u].add(v);
                g[v].add(u);
            }
            boolean ans=true;
            for(i=0;i<m;i++)
            {
                int u=bu.nextInt(),v=bu.nextInt();
                if(ans) ans=bfs(u,v);
            }
            for(i=1;i<=n;i++)
                if(flag[i]==0) {ans=false; break;}
            if(ans) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }

    static ArrayList<Integer> g[]=new ArrayList[1000002];
    static int flag[]=new int[1000002];
    static boolean vis[]=new boolean[1000002];

    static boolean bfs(int s,int d)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(s,d));
        vis[s]=true;
        while(!q.isEmpty())
        {
            Node p=q.poll();
            if(flag[p.n]==1) return false;
            if(p.d>0)
            {
                for(int i:g[p.n])
                if(!vis[i])
                {
                    vis[i]=true;
                    q.add(new Node(i,p.d-1));
                }
            }
            flag[p.n]=1;
        }
        return true;
    }

    static class Node
    {
        int n,d;
        Node(int a,int b)
        {
            n=a; d=b;
        }
    }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st==null || !st.hasMoreElements())
            {
                try
                {st=new StringTokenizer(br.readLine());}
                catch(IOException e)
                {e.printStackTrace();}
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

}
