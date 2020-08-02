problem link-https://www.spoj.com/problems/CANDY/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        while(n!=-1)
        {
            int i,a[]=new int[n],sum=0;
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(bu.readLine());
                sum+=a[i];
            }
            if(sum%n!=0) sb.append("-1\n");
            else
            {
                int req=sum/n; sum=0;
                for(i=0;i<n;i++)
                    sum+=Math.abs(a[i]-req);
                sum/=2;
                sb.append(sum+"\n");
            }
            n=Integer.parseInt(bu.readLine());
        }
        System.out.print(sb);
    }
}
