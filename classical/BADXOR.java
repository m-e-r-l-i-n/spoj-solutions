problem link-https://www.spoj.com/problems/BADXOR/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=fr.nextInt(),v;
        for(v=1;v<=t;v++)
        {
            int n=fr.nextInt(),m=fr.nextInt();
            long dp[][]=new long[n+1][1024],M=100000007;
            dp[0][0]=1;
            int i,j,a;
            for(i=1;i<=n;i++)
            {
                a=fr.nextInt();
                for(j=0;j<1024;j++)
                dp[i][j]=(dp[i-1][j]+dp[i-1][j^a])%M;
            }
            long ans=0,rem=0;
            for(i=0;i<1024;i++) ans=(ans+dp[n][i])%M;
            for(i=0;i<m;i++)
            {
                a=fr.nextInt();
                rem=(rem+dp[n][a])%M;
            }
            ans=(ans-rem+M)%M;
            sb.append("Case "+v+": "+ans+"\n");
        }
        System.out.print(sb);
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
