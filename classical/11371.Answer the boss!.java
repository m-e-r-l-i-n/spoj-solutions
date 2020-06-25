problem link-https://www.spoj.com/problems/RPLA/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=bu.nextInt(),cs=1;
        while(t-->0)
        {
            sb.append("Scenario #"+cs+++":\n");
            int n=bu.nextInt(),r=bu.nextInt(),i;
            ArrayList<Integer> g[]=new ArrayList[n];
            boolean vis[]=new boolean[n]; int deg[]=new int[n];
            for(i=0;i<n;i++)
            g[i]=new ArrayList<>();
            for(i=0;i<r;i++)
            {
                int l=bu.nextInt(),f=bu.nextInt();
                g[f].add(l);
                deg[l]++;
            }

            Queue<Pair> q=new LinkedList<>();
            ArrayList<Pair> ans=new ArrayList<>();
            for(i=0;i<n;i++)
            if(deg[i]==0)
            {
                vis[i]=true;
                q.add(new Pair(i,1));
            }

            while(!q.isEmpty())
            {
                Pair p=q.poll();
                ans.add(p);
                for(i=0;i<g[p.x].size();i++)
                if(!vis[g[p.x].get(i)])
                {
                    deg[g[p.x].get(i)]--;
                    if(deg[g[p.x].get(i)]==0)
                    {
                        vis[g[p.x].get(i)]=true;
                        q.add(new Pair(g[p.x].get(i),p.y+1));
                    }
                }
            }

            Collections.sort(ans, new Comparator<Pair>() {
                public int compare(Pair o1, Pair o2) {
                    if(o1.y>o2.y) return 1;
                    else if(o1.y==o2.y) return o1.x>o2.x?1:-1;
                    else return -1;
                }});

            for(i=0;i<ans.size();i++)
            sb.append(ans.get(i).y+" "+ans.get(i).x+"\n");
        }
        System.out.print(sb);
    }

    static class Pair
    {
        int x,y;
        Pair(int a,int b)
        {
            x=a; y=b;
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
