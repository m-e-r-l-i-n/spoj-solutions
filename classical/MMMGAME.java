problem link-https://www.spoj.com/problems/MMMGAME/

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
            int n=bu.nextInt();
            int i,a[]=new int[n],sum=0;
            for(i=0;i<n;i++)
            {
                a[i]=bu.nextInt();
                sum+=a[i];
            }
            String ans="";
            if(sum==n)
            {
                if(sum%2==0) ans="John";
                else ans="Brother";
            }
            else
            {
                int xor=0;
                for(i=0;i<n;i++)
                xor^=a[i];
                if(xor==0) ans="Brother";
                else ans="John";
            }
            sb.append(ans+"\n");
        }
        System.out.print(sb);
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
