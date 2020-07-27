problem link-https://www.spoj.com/problems/IITKWPCI/

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
            int n=bu.nextInt(),m=bu.nextInt();
            int i,a[]=new int[n],j,ans[]=new int[n];
            for(i=0;i<n;i++)
            {
                g[i]=new ArrayList<>();
                vis[i]=false;
                val[i]=-1;
                a[i]=bu.nextInt();
            }

            for(i=0;i<m;i++)
            {
                int l=bu.nextInt()-1,r=bu.nextInt()-1;
                g[l].add(r);
                g[r].add(l);
            }

            c=0;
            for(i=0;i<n;i++)
            if(!vis[i])
            {
                c++;
                dfs(i);
                ArrayList<Integer> ac=new ArrayList<>(),bc=new ArrayList<>();
                for(j=0;j<n;j++)
                if(val[j]==c)
                {
                    ac.add(j);
                    bc.add(a[j]);
                }
                Collections.sort(bc);
                for(j=0;j<bc.size();j++)
                ans[ac.get(j)]=bc.get(j);
            }

            for(i=0;i<n;i++)
            sb.append(ans[i]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int N=1011,c,val[]=new int[N];
    static ArrayList<Integer> g[]=new ArrayList[N];
    static boolean vis[]=new boolean[N];

    static void dfs(int n)
    {
        Stack<Integer> s=new Stack<>();
        vis[n]=true;
        s.add(n);
        while(!s.isEmpty())
        {
            int p=s.pop();
            val[p]=c;
            for(int x:g[p])
            if(!vis[x])
            {
                vis[x]=true;
                s.add(x);
            }
        }
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
