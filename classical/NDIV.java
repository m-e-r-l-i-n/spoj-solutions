problem link-https://www.spoj.com/problems/NDIV/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),n=Integer.parseInt(s[2]),i,c=0;
        for(i=a;i<=b;i++)
        {
            int j,x=1,u=i;
            for(j=2;j*j<=u;j++)
            if(u%j==0)
            {
                int cn=1;
                while(u%j==0) {u/=j; cn++;}
                x*=cn;
                if(x>n) break;
            }
            if(u>=2) x*=2;
            if(x==n) c++;
        }
        System.out.print(c);
    }
}
