problem link-https://www.spoj.com/problems/DISTANCE/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),d=Integer.parseInt(s[1]);
        int x,a[]=new int[d],i,j,sz=1<<(d-1),max[]=new int[sz],min[]=new int[sz];
        Arrays.fill(max,Integer.MIN_VALUE);
        Arrays.fill(min,Integer.MAX_VALUE);

        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<d;j++)
            a[j]=Integer.parseInt(s[j]);

            /*
            for d=2, Manhattan distance between 2 points=|x1-x2|+|y1-y2|
            let X=x+y,Y=x-y
            so Manhattan distance can be written as max(|X1-X2|,|Y1-Y2|)
            this is known as Chebyshev distance and works for higher dimensions as well(more combinations for d>2)
             */

            for(j=0;j<sz;j++)   //fetch all combinations
            {
                x=a[0];
                for(int k=0;k<d-1;k++)
                if(((j>>k)&1)==1) x+=a[k+1];
                else x-=a[k+1];
                max[j]=Math.max(max[j],x);
                min[j]=Math.min(min[j],x);
            }
        }

        int ans=0;
        for(i=0;i<sz;i++)
        ans=Math.max(ans,Math.abs(max[i]-min[i]));
        System.out.print(ans);
    }
}
