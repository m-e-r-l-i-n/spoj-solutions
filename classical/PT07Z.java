problem link-https://www.spoj.com/problems/PT07Z/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i; ans=0; d=new int[n];
        g=new ArrayList[n]; vis=new boolean[n];
        for(i=0;i<n;i++)
        g[i]=new ArrayList<>();
        vis[0]=true;
        for(i=0;i<n-1;i++)
        {
            StringTokenizer st=new StringTokenizer(bu.readLine());
            int u=Integer.parseInt(st.nextToken())-1,v=Integer.parseInt(st.nextToken())-1;
            g[u].add(v);
            g[v].add(u);
        }
        dfs(0);
        System.out.print(ans);
    }

    static ArrayList<Integer> g[];
    static int d[],ans;
    static boolean vis[];

    static void dfs(int x)
    {
        if(g[x].size()==1 && vis[g[x].get(0)])
        {
            d[x]=1;
            return;
        }

        int max=0,max2=0;
        for(int u:g[x])
        if(!vis[u])
        {
            vis[u]=true;
            dfs(u);
            if(d[u]>=max)
            {
                max2=max;
                max=d[u];
            }
            else if(d[u]>max2) max2=d[u];
        }
        ans=Math.max(ans,max);
        d[x]=max+1;
        if(max2!=-1) ans=Math.max(ans,max+max2);
    }
}
