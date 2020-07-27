problem link-https://www.spoj.com/problems/REDARR2/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine()),k,i;
            PriorityQueue<Long> pq=new PriorityQueue<>();
            String s[]=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                k=Integer.parseInt(s[i]);
                pq.add((long)k);
            }
            long cost=0;
            while(pq.size()>1)
            {
                long a=pq.poll(),b=pq.poll();
                cost+=a+b;
                pq.add(a+b);
            }
            sb.append(cost+"\n");
        }
        System.out.print(sb);
    }
}
