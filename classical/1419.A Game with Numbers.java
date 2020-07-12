problem link-https://www.spoj.com/problems/NGM/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        if(n%10==0) sb.append("2\n");
        else
        {
            sb.append("1\n");
            sb.append(n%10);
        }
        System.out.print(sb);
    }
}
