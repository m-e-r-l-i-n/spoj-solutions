problem link-https://www.spoj.com/problems/ARITH2/

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
            bu.readLine();
            StringTokenizer s=new StringTokenizer(bu.readLine());
            long cur=Long.parseLong(s.nextToken());
            while(s.hasMoreTokens())
            {
                char op=s.nextToken().charAt(0);
                if(op=='=') break;
                long nxt=Long.parseLong(s.nextToken());
                if(op=='+') cur+=nxt;
                else if(op=='-') cur-=nxt;
                else if(op=='*') cur*=nxt;
                else cur/=nxt;
            }
            sb.append(cur+"\n");
        }
        System.out.print(sb);
    }
}
