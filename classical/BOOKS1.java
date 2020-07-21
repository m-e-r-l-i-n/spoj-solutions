problem link-https://www.spoj.com/problems/BOOKS1/

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
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),a[]=new int[n],i;
            int l=Integer.MAX_VALUE,r=0,mid,sum=0;
            s=bu.readLine().split(" ");
            for(i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s[i]);
                r+=a[i];
                if(a[i]<l) l=a[i];
            }
            while(l<r)
            {
                mid=l+(r-l)/2;
                if(binary_check(a,k,mid)) r=mid;
                else l=mid+1;
            }
            mid=0; l=1;
            ArrayList<Integer> al=new ArrayList<>();
            for(i=n-1;i>=0;i--)     //excellent way to print answer found on github
            {
                if(mid+a[i]>r || i==k-l-1)
                {
                    al.add(-1);
                    l++;
                    mid=0;
                }
                mid+=a[i];
                al.add(a[i]);
            }
            for(i=al.size()-1;i>=0;i--)
            if(al.get(i)==-1) sb.append("/ ");
            else sb.append(al.get(i)+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean binary_check(int a[],int k,int sum)
    {
        int c=1,i,s=0;
        for(i=a.length-1;i>=0;i--)
        {
            if(a[i]>sum) {c=k+1; break;}
            if(s+a[i]>sum) {s=0; c++;}
            s+=a[i];
        }
        return c<=k;
    }
}
