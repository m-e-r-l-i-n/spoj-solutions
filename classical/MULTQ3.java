problem link-https://www.spoj.com/problems/MULTQ3/

import java.io.*;

class Spoj
{
    static int n,q;
    static Node st[];    //segment tree

    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        n=bu.nextInt(); q=bu.nextInt();
        st=new Node[n<<2];
        build(1,0,n-1);

        while(q-->0)
        {
            int op=bu.nextInt(),x=bu.nextInt(),y=bu.nextInt();
            if(op==0) update(1,0,n-1,x,y);
            else bw.write(query(1,0,n-1,x,y)+"\n");
        }
        bw.flush();
    }

    static class Node
    {
        int three,two,one,lazy;
        Node()
        {
            three=two=one=lazy=0;
        }
    }

    static void build(int i,int l,int r)
    {
        st[i]=new Node();
        if(l==r) st[i].three=1;
        else
        {
            int p=i<<1,mid=(l+r)>>1;
            build(p,l,mid);
            build(p+1,mid+1,r);
            st[i].three=st[p].three+st[p+1].three;
        }
    }

    static void propagate(int i,int l,int r)
    {
        if(l!=r)
        {
            int p=i<<1;
            st[p].lazy+=st[i].lazy;
            st[p+1].lazy+=st[i].lazy;
        }
        st[i].lazy%=3;

        if(st[i].lazy==1)
        {
            int t=st[i].three;
            st[i].three=st[i].one;
            st[i].one=st[i].two;
            st[i].two=t;
        }
        else if(st[i].lazy==2)
        {
            int t=st[i].three;
            st[i].three=st[i].two;
            st[i].two=st[i].one;
            st[i].one=t;
        }
        st[i].lazy=0;
    }

    static void update(int i,int l,int r,int x,int y)
    {
        propagate(i,l,r);
        if(l>=x && r<=y)
        {
            st[i].lazy++;
            propagate(i,l,r);
            return;
        }
        else if(l>y || r<x) return;
        else
        {
            int p=i<<1, mid=(l+r)>>1;
            update(p,l,mid,x,y);
            update(p+1,mid+1,r,x,y);
            st[i].three=st[p].three+st[p+1].three;
            st[i].two=st[p].two+st[p+1].two;
            st[i].one=st[p].one+st[p+1].one;
        }
    }

    static int query(int i,int l, int r,int x,int y)
    {
        propagate(i,l,r);
        if(l>y || r<x) return 0;
        else if(l>=x && r<=y) return st[i].three;
        int p=i<<1,mid=(l+r)>>1;
        return query(p,l,mid,x,y)+query(p+1,mid+1,r,x,y);
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
