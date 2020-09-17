problem link-https://www.spoj.com/problems/CHAIN/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt(),r[]=new int[50000],d[]=new int[50000];
        while(t-->0)
        {
            int n=fr.nextInt(),k=fr.nextInt();
            int i;
            for(i=0;i<n;i++)
            {
                r[i]=i;
                d[i]=0;
            }

            int ans=0;
            while(k-->0)
            {
                int ty=fr.nextInt()-1,x=fr.nextInt()-1,y=fr.nextInt()-1;
                if(x>=n || y>=n) {ans++; continue;}

                int px=find(r,d,x),py=find(r,d,y),temp;
                if(px==py)
                {
                    temp=(d[x]-d[y])%3;
                    if(temp<0) temp+=3;
                    if(temp!=ty) ans++;
                }
                else
                {
                    r[px]=py;
                    temp=(d[x]-d[y]-ty)%3;
                    d[px]=temp<0?-temp:-temp+3;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int find(int r[],int d[],int n)
    {
        if(n==r[n]) return n;
        int t=r[n];
        r[n]=find(r,d,r[n]);
        d[n]=d[t]+d[n];
        return r[n];
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
