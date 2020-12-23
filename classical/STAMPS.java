problem link-https://www.spoj.com/problems/STAMPS/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine()),v;
        for(v=1;v<=t;v++)
        {
            sb.append("Scenario #"+v+":\n");
            String s[]=bu.readLine().split(" ");
            int st=Integer.parseInt(s[0]),n=Integer.parseInt(s[1]),i,a[]=new int[n];
            int sum=0;
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                sum+=a[i];
            }
            if(sum<st) {sb.append("impossible\n\n"); continue;}

            Arrays.sort(a);
            int ans; sum=0;
            for(i=n-1,ans=0; i>=0 && sum<st;i--,ans++)
            sum+=a[i];
            sb.append(ans+"\n\n");
        }
        System.out.print(sb);
    }
}
