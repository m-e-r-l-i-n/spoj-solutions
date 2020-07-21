problem link-https://www.spoj.com/problems/COINS/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s=bu.readLine();
        while(s!=null)
        {
            int n=Integer.parseInt(s);
            sb.append(maxim(n)+"\n");
            s=bu.readLine();
        }
        System.out.print(sb);
    }
    static HashMap<Long,Long> hm=new HashMap<>();
    static long maxim(long n)
    {
        if(n==0) return 0;
        else if(hm.get(n)!=null) return hm.get(n);
        else
        {
            long v=maxim(n/2)+maxim(n/3)+maxim(n/4);
            hm.put(n,Math.max(n,v));
            return hm.get(n);
        }
    }
}
