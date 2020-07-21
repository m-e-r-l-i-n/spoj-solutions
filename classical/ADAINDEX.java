problem link-https://www.spoj.com/problems/ADAINDEX/

import java.io.*;
import java.util.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        FastReader bu=new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=bu.nextInt(),q=bu.nextInt(),i,j;
        Trie t=new Trie();

        for(i=0;i<n;i++)
        {
            String s=bu.nextLine();
            int l=s.length();
            if(l>0) add(t,s);
        }

        while(q-->0)
        {
            String s=bu.nextLine();
            long ans=find(t,s);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static class Trie
    {
        Trie a[];
        long c;
        Trie()
        {
            a=new Trie[26];
            c=0;
        }
    }

    static void add(Trie n,String s)
    {
        int i,l=s.length();
        if(l==0) return;
        for(i=0;i<l;i++)
        {
            if(n.a[s.charAt(i)-'a']==null) n.a[s.charAt(i)-'a']=new Trie();
            n=n.a[s.charAt(i)-'a'];
            n.c++;
        }
    }

    static long find(Trie n,String s)
    {
        int i,l=s.length();
        if(l==0) return 0;
        for(i=0;i<s.length();i++)
        {
            if(n.a[s.charAt(i)-'a']==null) return 0;
            n=n.a[s.charAt(i)-'a'];
        }
        return n.c;
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

        String nextLine()
        {
            String str="";
            try
            {str=br.readLine();}
            catch(IOException e)
            {e.printStackTrace();}
            return str;
        }
    }
}
