problem link-https://www.spoj.com/problems/PRATA/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int p=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),a[]=new int[n],i;
            for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i+1]);
            int l=1,r=10000000,mid=0;
            while(l<r)
            {
                mid=(l+r)/2;
                if(binary_check(a,p,mid)) r=mid;
                else l=mid+1;
            }
            sb.append(l+"\n");
        }
        System.out.print(sb);
    }

    static boolean binary_check(int a[],int p,int time)
    {
        int c=0,i;
        for(i=0;i<a.length;i++)
        {
            c+=(-1+(int)Math.sqrt(1+8*time/a[i]))/2;
            if(c>=p) return true;
        }
        return false;
    }
}
