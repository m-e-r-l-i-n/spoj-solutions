problem link-https://www.spoj.com/problems/OLOLO/

import java.io.*;
class Sopj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),i,x=0;
        for(i=0;i<n;i++)
            x^=Integer.parseInt(bu.readLine());
        System.out.print(x);
    }
}
