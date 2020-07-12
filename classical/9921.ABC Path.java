problem link-https://www.spoj.com/problems/ABCPATH/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int h=Integer.parseInt(s[0]),w=Integer.parseInt(s[1]),a[][]=new int[50][50],t=0;
        int m1[]={-1,0,1,1,1,0,-1,-1}, m2[]={-1,-1,-1,0,1,1,1,0};
        boolean vis[][]=new boolean[50][50];
        while(h!=0 && w!=0)
        {
            int i,j;
            Queue<Pair> q=new LinkedList<>();
            for(i=0;i<h;i++)
            {
                String ss=bu.readLine();
                for(j=0;j<w;j++)
                {
                    a[i][j]=ss.charAt(j)-'A'+1;
                    vis[i][j]=false;
                    if(a[i][j]==1)
                    {q.add(new Pair(i,j)); vis[i][j]=true;}
                }
            }
            int max=0;
            while(!q.isEmpty())
            {
                Pair p=q.poll();
                max=Math.max(max,a[p.x][p.y]);
                for(i=0;i<8;i++)
                {
                    int x=p.x+m1[i],y=p.y+m2[i];
                    if(x>=0 && x<h && y>=0 && y<w && a[x][y]==(a[p.x][p.y]+1))
                    if(!vis[x][y])
                    {
                        vis[x][y]=true;
                        q.add(new Pair(x,y));
                    }
                }
            }
            ++t;
            sb.append("Case "+t+": "+max+"\n");
            s=bu.readLine().split(" ");
            h=Integer.parseInt(s[0]); w=Integer.parseInt(s[1]);
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
}
