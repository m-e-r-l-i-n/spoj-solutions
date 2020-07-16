problem link-https://www.spoj.com/problems/EKO/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,a[]=new int[n];
        long sum=0,l=1,r=0,ans=0,mid;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            r=Math.max(r,a[i]);
        }

        while(l<=r)
        {
            mid=(l+r)/2;
            sum=0;
            for(i=0;i<n;i++)
                sum+=Math.max(0,a[i]-mid);
            if(sum>=m)
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.print(ans);
    }
}
