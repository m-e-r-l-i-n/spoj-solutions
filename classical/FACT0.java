problem link-https://www.spoj.com/problems/FACT0/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true)
        {
            long n=Long.parseLong(bu.readLine());
            if(n==0) break;
            long i; int c=0;
            HashMap<Long,Integer> hm=new HashMap<>();
            ArrayList<Long> al=new ArrayList<>();
            for(i=2;i*i<=n;i++)
            if(n%i==0)
            {
                c=0;
                while(n%i==0) {c++; n/=i;}
                hm.put(i,c);
                al.add(i);
            }
            if(n>=2) {al.add(n); hm.put(n,1);}
            Collections.sort(al);

            for(c=0;c<al.size();c++)
            sb.append(al.get(c)+"^"+hm.get(al.get(c))+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
