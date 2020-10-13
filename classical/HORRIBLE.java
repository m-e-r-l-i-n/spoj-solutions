problem link-https://www.spoj.com/problems/HORRIBLE/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt();
        while(t-->0)
        {
            int n=fr.nextInt()+5,c=fr.nextInt();
            long bit1[]=new long[n+1],bit2[]=new long[n+1];
            while(c-->0)
            {
                int ch=fr.nextInt();
                if(ch==0)
                {
                    int l=fr.nextInt(),r=fr.nextInt();
                    long val=fr.nextInt();
                    update(bit1,n,l,val);
                    update(bit1,n,r+1,-val);
                    update(bit2,n,l,val*(l-1));
                    update(bit2,n,r+1,-val*r);
                }
                else
                {
                    int l=fr.nextInt(),r=fr.nextInt();
                    long ans=(sum(bit1,r,n)*r-sum(bit2,r,n))-(sum(bit1,l-1,n)*(l-1)-sum(bit2,l-1,n));
                    sb.append(ans+"\n");
                }
            }
        }
        System.out.print(sb);
    }

    static void update(long bit[],int n,int i,long v)
    {
        i++;
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }

    static long sum(long bit[],int i,int n)
    {
        long s=0;
        i++;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
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
