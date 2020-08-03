problem link-https://www.spoj.com/problems/LABYR1/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[1]),m=Integer.parseInt(s[0]),i,j;
            char b[][]=new char[n][m];
            for(i=0;i<n;i++)
            {
                String st=bu.readLine();
                for(j=0;j<m;j++)
                b[i][j]=st.charAt(j);
            }

            boolean vis[][]=new boolean[n][m];
            int ans=-1;
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    if(!vis[i][j] && b[i][j]=='.') ans=bfs(b,vis,n,m,i,j);
                    if(ans!=-1) break;
                }
                if(ans!=-1) break;
            }

            boolean v2[][]=new boolean[n][m];
            ans=bfs(b,v2,n,m,end.x,end.y);
            sb.append("Maximum rope length is "+ans+".\n");
        }
        System.out.print(sb);
    }

    static Point end=new Point(0,0,0);

    static int bfs(char g[][], boolean v[][],int n,int m,int r,int c)
    {
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(r,c,0));
        int max=0,moves[][]={{1,0},{0,1},{-1,0},{0,-1}};
        v[r][c]=true;
        while(!q.isEmpty())
        {
            Point p=q.poll();
            if(p.l>max)
            {
                max=p.l;
                end=p;
            }
            for(int mv[]:moves)
            {
                int i=p.x+mv[0],j=p.y+mv[1];
                if(i<0 || i>=n || j<0 || j>=m) continue;
                if(v[i][j] || g[i][j]=='#') continue;
                v[i][j]=true;
                q.add(new Point(i,j,p.l+1));
            }
        }
        return max;
    }

    static class Point
    {
        int x,y,l;
        Point(int a,int b,int c)
        {
            x=a;
            y=b;
            l=c;
        }
    }
}
