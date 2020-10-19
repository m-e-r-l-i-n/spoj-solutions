problem link-https://www.spoj.com/problems/JULKA/

import java.io.*;
import java.math.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=10;
        while(t-->0)
        {
            String s=bu.readLine().trim();
            BigInteger a=new BigInteger(s);
            s=bu.readLine().trim();
            BigInteger b=new BigInteger(s);
            BigInteger x=a.subtract(b).divide(BigInteger.valueOf(2));
            sb.append(x.add(b)+"\n");
            sb.append(x+"\n");
        }
        System.out.print(sb);
    }
}
