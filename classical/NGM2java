problem link-https://www.spoj.com/problems/NGM2/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        int i,j,tot=(int)Math.pow(2,k),a[]=new int[k];
        s=bu.readLine().split(" ");
        for(i=0;i<k;i++)
        a[i]=Integer.parseInt(s[i]);

        long sum=n,b;
        for(i=1;i<tot;i++)
        {
            b=1; int c=0;
            for(j=0;j<k;j++)
            if((i&(1<<j))!=0)
            {
                c++;
                b=(b*a[j])/gcd(b,a[j]);
            }
            if(c%2==0) sum+=n/b;
            else sum-=n/b;
        }
        System.out.print(sum);
    }

    static long gcd(long a,long b)
    {
        long t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
