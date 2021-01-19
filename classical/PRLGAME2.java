problem link-https://www.spoj.com/problems/PRLGAME2/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s=bu.readLine(); int t=1;
        while(s!=null && s.length()!=0)
        {
            String a[]=s.split(" ");
            int n=Integer.parseInt(a[0]),p=Integer.parseInt(a[1]),q=Integer.parseInt(a[2]);
            long den=q+1,num=p+2;
            double ans=1.0*den/num;
            System.out.print("Case "+t+": ");
            t++;
            System.out.format("%.4f\n",ans);
            s=bu.readLine();
        }
    }
}
