problem link-https://www.spoj.com/problems/GIVEAWAY/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=fr.nextInt();
        int sqrt=(int)Math.sqrt(1.0*n)+1,i,a[]=new int[n];
        int b[][]=new int[sqrt][sqrt];
        for(i=0;i<n;i++)
        {
            a[i]=fr.nextInt();
            b[i/sqrt][i%sqrt]=a[i];
        }

        for(i=0;i<sqrt;i++)
        Arrays.sort(b[i]);

        int q=fr.nextInt();
        while(q-->0)
        {
            int t=fr.nextInt();
            if(t==1)
            {
                int p=fr.nextInt()-1,v=fr.nextInt();
                int block=p/sqrt;
                for(i=0;i<sqrt;i++)
                if(b[block][i]==a[p])
                {
                    b[block][i]=v;
                    a[p]=v;
                    break;
                }
                Arrays.sort(b[block]);
            }
            else
            {
                int l=fr.nextInt()-1,r=fr.nextInt()-1,v=fr.nextInt();
                int lb=l/sqrt,rb=r/sqrt,ans=0;
                if(lb==rb)
                {
                    for(i=l;i<=r;i++)
                    if(a[i]>=v) ans++;
                }
                else
                {
                    int end=(lb+1)*sqrt-1;
                    for(i=l;i<=Math.min(n-1,end);i++)
                    if(a[i]>=v) ans++;
                    for(i=rb*sqrt;i<=r;i++)
                    if(a[i]>=v) ans++;

                    for(i=lb+1;i<rb;i++)
                    ans+=lower(b[i],0,sqrt,v);
                }
                sb.append(ans+"\n");
            }
        }
        System.out.print(sb);
    }

    static int lower(int a[],int l,int r,int c)
    {
        while(l<r)
        {
            int mid=(l+r)/2;
            if(a[mid]<c) l=mid+1;
            else r=mid;
        }
        return Math.max(a.length-l,0);
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
