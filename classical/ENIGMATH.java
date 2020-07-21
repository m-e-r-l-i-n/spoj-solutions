problem link-https://www.spoj.com/problems/ENIGMATH/

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
            String s[]=bu.readLine().split(" ");
            int a=Integer.parseInt(s[0]),b=Integer.parseInt(s[1]),x=0,y=0;
            int g=gcd(a,b);
            x=b/g; y=a/g;
            sb.append(x+" "+y+"\n");
        }
        System.out.print(sb);
    }

    static int gcd(int a,int b)
    {
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
