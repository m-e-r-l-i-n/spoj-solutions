problem link-https://www.spoj.com/problems/EOD/

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
            char s[]=bu.readLine().toCharArray();
            int e=0,o=0,i,n=s.length;
            for(i=0;i<n;i++)
            if(s[i]%2==0) e++;
            else o++;
            if(o>e) sb.append("odd\n");
            else sb.append("even\n");
        }
        System.out.print(sb);
    }
}
