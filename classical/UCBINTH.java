problem link-https://www.spoj.com/problems/UCBINTH/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[2]),k=Integer.parseInt(s[1]),i,j,N=200005;
        ArrayList<Integer> g[][]=new ArrayList[N][2];
        for(i=0;i<N;i++)
        {
            g[i][0]=new ArrayList<>();
            g[i][1]=new ArrayList<>();
        }

        Queue<Integer> q[]=new Queue[2];
        for(i=0;i<2;i++)
        q[i]=new LinkedList<>();

        //thank you zympha(link-https://github.com/zimpha/competitive-programming/blob/master/spoj/UCBINTH.cc)
        for(i=0;i<m;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<k;j++)
            {
                int x=Integer.parseInt(s[j])-1;
                g[i+n][1].add(x);   //add stations to hypertubes
                g[x][0].add(i+n);   //add hypertubes to stations
            }
        }

        int dis[]=new int[n+m];
        Arrays.fill(dis,-1);
        dis[0]=1;
        q[0].add(0);
        i=0;
        while(!q[i].isEmpty())
        {
            while(!q[i].isEmpty())  //iterate the outer queue
            {
                int u=q[i].poll();
                for(int x:g[u][i])
                if(dis[x]==-1)
                {
                    dis[x]=dis[u]+i;    //calculate distance of unvisited elements
                    q[i^1].add(x);
                }
            }
            i^=1;   //inner queue becomes outer now
        }
        System.out.print(dis[n-1]);
    }
}
